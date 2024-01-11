package com.example.trybil.view;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.trybil.R;
import com.example.trybil.databinding.RegisterFragmentBinding;
import com.example.trybil.viewmodel.AuthViewModel;
import com.google.firebase.auth.FirebaseUser;

public class RegisterFragment extends Fragment {
    private RegisterFragmentBinding registerFragmentBinding;
    private AuthViewModel mViewModel;
    private NavController navController;
    private boolean isStudent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        registerFragmentBinding = RegisterFragmentBinding.inflate(inflater, container, false);
        return registerFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        isStudent = true;

        registerFragmentBinding.buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = registerFragmentBinding.editTextEmailReg.getText().toString();
                String pass = registerFragmentBinding.editTextPasswordReg.getText().toString();
                String username = registerFragmentBinding.editTextUsername.getText().toString();
                String department;

                if (isStudent) {
                    department = registerFragmentBinding.spinnerDep.getSelectedItem().toString();
                }
                else {
                    department = "Staff";
                }

                if (!email.isEmpty() && !pass.isEmpty()){
                    mViewModel.register(email , pass, username, department);
                }
            }
        });

        registerFragmentBinding.textSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_registerFragment_to_loginFragment);
                //finish
            }
        });

        registerFragmentBinding.rgReg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int rb = group.getCheckedRadioButtonId();

                if (rb == R.id.rbStaff) {
                    registerFragmentBinding.spinnerDep.setEnabled(false);
                    isStudent = false;
                }
                else {
                    registerFragmentBinding.spinnerDep.setEnabled(true);
                    isStudent = true;
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        registerFragmentBinding = null;
    }
}