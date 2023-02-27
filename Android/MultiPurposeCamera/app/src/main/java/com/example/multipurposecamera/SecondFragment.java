package com.example.multipurposecamera;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.multipurposecamera.databinding.FragmentSecondBinding;


/**
 * The class Second fragment extends fragment
 */
public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override


/**
 *
 * On create view
 *
 * @param inflater  the inflater
 * @param container  the container
 * @param Bundle  the bundle
 * @return View
 */
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {


        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }


    /**
     *
     * On view created
     *
     * @param View  the view
     * @param savedInstanceState  the saved instance state
     */
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override

/**
 *
 * On click
 *
 * @param view  the view
 */
            public void onClick(View view) {

                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override

/**
 *
 * On destroy view
 *
 */
    public void onDestroyView() {

        super.onDestroyView();
        binding = null;
    }

}
