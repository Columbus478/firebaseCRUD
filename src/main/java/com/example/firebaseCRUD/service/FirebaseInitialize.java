package com.example.firebaseCRUD.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Service
public class FirebaseInitialize {
  @PostConstruct
  public void inti() {
    FileInputStream serviceAccount;
    try {
      serviceAccount = new FileInputStream("./firebaseserviceAccountKey.json");
      @SuppressWarnings("deprecation")
      FirebaseOptions options =
          new FirebaseOptions.Builder().setCredentials(GoogleCredentials.fromStream(serviceAccount))
              .setDatabaseUrl("https://fir-crud-5994b.firebaseio.com").build();

      FirebaseApp.initializeApp(options);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}
