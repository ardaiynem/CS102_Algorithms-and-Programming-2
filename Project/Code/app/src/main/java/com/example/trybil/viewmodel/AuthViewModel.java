package com.example.trybil.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.trybil.model.AuthRepository;
import com.google.firebase.auth.FirebaseUser;

public class AuthViewModel extends AndroidViewModel {
    AuthRepository authRepository;
    MutableLiveData<FirebaseUser> userData;
    MutableLiveData<Boolean> loggedStatus;

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }

    public AuthViewModel(@NonNull Application application) {
        super(application);
        authRepository = AuthRepository.getInstance(application);
        userData = authRepository.getFirebaseUserMutableLiveData();
        loggedStatus = authRepository.getUserLoggedMutableLiveData();
    }

    public void register(String email , String pass, String username, String department){
        authRepository.checkUsernameFirst(email, pass, username, department);
    }
    public void signIn(String email , String pass){
        authRepository.login(email, pass);
    }
    public void loginAnon(){
        authRepository.loginAnon();
    }
    public void signOut(){
        authRepository.signOut();
    }
}
