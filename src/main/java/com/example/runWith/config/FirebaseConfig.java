//package com.example.runWith.config;
//
//import com.google.api.client.util.Value;
//import com.google.auth.oauth2.GoogleCredentials;
//import com.google.firebase.FirebaseApp;
//import com.google.firebase.FirebaseOptions;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.messaging.FirebaseMessaging;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.io.ClassPathResource;
//import org.springframework.core.io.Resource;
//
//import javax.annotation.PostConstruct;
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@Configuration
//public class FirebaseConfig {
//    @Value("${firebase.sdk.path}")
//    private String firebaseSdkPath;
//
//    private FirebaseApp firebaseApp;
//
//    @PostConstruct
//    public FirebaseApp initializeFCM() throws IOException {
//        Resource resource = new ClassPathResource(firebaseSdkPath);
//        FileInputStream fis = new FileInputStream(resource.getFile());
//        FirebaseOptions options = new FirebaseOptions.Builder()
//                .setCredentials(GoogleCredentials.fromStream(fis))
//                .build();
//        firebaseApp = FirebaseApp.initializeApp(options, "runWith");
//        return firebaseApp;
//    }
//
//    @Bean
//    public FirebaseAuth initFirebaseAuth() {
//        FirebaseAuth instance = FirebaseAuth.getInstance(firebaseApp);
//        return instance;
//    }
//
//    @Bean
//    public FirebaseMessaging initFirebaseMessaging() {
//        FirebaseMessaging instance = FirebaseMessaging.getInstance(firebaseApp);
//        return instance;
//    }
//}
