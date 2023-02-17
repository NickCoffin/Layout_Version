package com.example.multipurposecamera;

import com.jcraft.jsch.*;

import java.io.InputStream;

import android.os.AsyncTask;
import android.util.Log;

public class SSHConnection extends AsyncTask<Void, Void, String>{

    protected String doInBackground(Void... voids){
        System.out.println("starting ssh task: ");
        String result = start_connection();
        return result;
    }

    @Override
    protected void onPostExecute(String result) {
        System.out.println("finished task:");
        if(result != null)
            Log.d("Result", result);
    }

    public static String start_connection() {
        System.out.println("Starting creating connection");
        String password = "ZxXGmnQ9v$T)CBrlKFcell=gG2@jh?F=";
        password = null;
        String host = "ec2-44-193-75-190.compute-1.amazonaws.com";

        String user = "ec2-user";
        try {
            JSch jsch = new JSch();

            // Set the hostname and port number of the server

            int port = 22;

            // Create a session object
            Session session = jsch.getSession(user, host, port);

            // Set the password for the session
            session.setPassword(password);

            // Configure the session to not check for the host key
            java.util.Properties config = new java.util.Properties();
            config.put("StrictHostKeyChecking", "no");
            session.setConfig(config);

            // Connect to the server
            session.connect();

            // Open a channel for executing commands
            Channel channel = session.openChannel("exec");

            // Set the command to run on the server
            ((ChannelExec)channel).setCommand("ls");

            // Connect the channel
            channel.connect();

            String result = "";
            // Read the output from the server
            InputStream input = channel.getInputStream();
            System.out.println("PRINTING SSH CONNECTION");
            byte[] buffer = new byte[1024];
            while (input.available() > 0) {
                int i = input.read(buffer, 0, 1024);
                if (i < 0) {
                    break;
                }
                result += new String(buffer, 0, i);
                //System.out.print(new String(buffer, 0, i));
            }

            // Close the channel and session
            channel.disconnect();
            session.disconnect();
            return result;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}