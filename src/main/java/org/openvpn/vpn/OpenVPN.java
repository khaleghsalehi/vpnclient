
//    OpenVPN -- An application to securely tunnel IP networks
//               over a single port, with support for SSL/TLS-based
//               session authentication and key exchange,
//               packet encryption, packet authentication, and
//               packet compression.
//
//    Copyright (C) 2012-2017 OpenVPN Technologies, Inc.
//
//    This program is free software: you can redistribute it and/or modify
//    it under the terms of the GNU General Public License Version 3
//    as published by the Free Software Foundation.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program in the COPYING file.
//    If not, see <http://www.gnu.org/licenses/>.

// TESTING_ONLY

package org.openvpn.vpn;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static java.lang.System.exit;

public class OpenVPN {
    // utility method to read a file and return as a String
    private static final String username = "";
    private static final String password = "";
    private static final String proxyHost = "";
    private static final String proxyPort = "";
    private static final String proxyUserName = "";
    private static final String proxyPassword = "";
    public static Boolean isFinished = false;

    public static String readFile(String filename) throws IOException {
        return readStream(new FileInputStream(filename));
    }

    private static String readStream(InputStream stream) throws IOException {
        try {
            Reader reader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();
            char[] buffer = new char[4096];
            int read;
            while ((read = reader.read(buffer, 0, buffer.length)) > 0) {
                builder.append(buffer, 0, read);
            }
            return builder.toString();
        } finally {
            // Potential issue here: if this throws an IOException,
            // it will mask any others. Normally I'd use a utility
            // method which would log exceptions and swallow them
            stream.close();
        }
    }

    public static void main(String[] args) throws IOException, VPNClient.ConfigError, VPNClient.CredsUnspecifiedError {
        // TODO: khalegh 12/25/20  fetch or update config from remote server
        String config = readFile("/etc/openvpn/client.conf");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        final String[] value = new String[1];
        final VPNClient client = new VPNClient(config, username, password, proxyHost, proxyPort,
                proxyUserName, proxyPassword);
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        final Runnable task = () -> {
            if (client.isConnected()) {
                System.out.println("client connected successfully.");
                try {
                    System.out.println("command >");
                    value[0] = reader.readLine();
                    if (value[0].equals("exit"))
                        isFinished = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (isFinished) {
                    System.out.println("exit service...");
                    client.stopThread();
                    exit(0);
                }
            } else {
                System.out.println(":( client is not connected");
            }
        };
        Future<?> futureHandle = scheduler.scheduleWithFixedDelay(task, 1, 1, TimeUnit.SECONDS);
        client.connectVpn();
    }
}
