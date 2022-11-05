package com.example.runWith.util;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.AndroidConfig;
import com.google.firebase.messaging.AndroidNotification;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Component
public class FcmUtil {
    public void send_FCM(String tokenId, String title, String content) {
        try {
            FileInputStream refreshToken = new FileInputStream("C:\\Work\\RunWith\\RunWithServer\\src\\main\\resources\\runwith-server-firebase-adminsdk-tmh70-88e1a7c13a.json");

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(refreshToken))
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }

            String registrationToken = tokenId;

            Message msg = Message.builder()
                    .setAndroidConfig(AndroidConfig.builder()
                            .setTtl(3600*1000)
                            .setPriority(AndroidConfig.Priority.NORMAL)
                            .setNotification(AndroidNotification.builder()
                                    .setTitle(title)
                                    .setBody(content)
                                    .setColor("#f45342")
                                    .build())
                            .build())
                    .setToken(registrationToken)
                    .build();
            String response = FirebaseMessaging.getInstance().send(msg);
            System.out.println("response message : " + response);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
