package com.example.firebaseCRUD.service;

import java.util.concurrent.ExecutionException;
import org.springframework.stereotype.Service;
import com.example.firebaseCRUD.objects.Person;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

@Service
public class FirebaseService {

  public String saveUserDetails(Person person) throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> collectionsApiFutures =
        dbFirestore.collection("users").document(person.getName()).set(person);
    return collectionsApiFutures.get().getUpdateTime().toString();
  }

  public Person getUserDetails(String name) throws InterruptedException, ExecutionException {
    Firestore dbFirestore = FirestoreClient.getFirestore();
    DocumentReference documentReference = dbFirestore.collection("users").document(name);
    ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();

    DocumentSnapshot documentSnapshot = apiFuture.get();
    if (documentSnapshot.exists()) {
      Person person = documentSnapshot.toObject(Person.class);
      return person;
    } else {
      return null;
    }
  }

  public String updateUserDetails(Person person) throws InterruptedException, ExecutionException {
    Firestore dbfirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> apiFuture =
        dbfirestore.collection("users").document(person.getName()).set(person);
    return apiFuture.get().getUpdateTime().toString();

  }

  public String deleteUser(String name) throws InterruptedException, ExecutionException {
    Firestore dbfirestore = FirestoreClient.getFirestore();
    ApiFuture<WriteResult> apiFuture = dbfirestore.collection("users").document(name).delete();
    return "User: " + name + " has been deleted successfully at "
        + apiFuture.get().getUpdateTime().toString();
  }

}
