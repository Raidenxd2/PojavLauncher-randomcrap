package net.kdt.pojavlaunch;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import net.kdt.pojavlaunch.progresskeeper.ProgressKeeper;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ModManagerMain#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ModManagerMain extends Fragment {

    public static final String TAG = "ModMenuMainFragment";

    public ModManagerMain() {
        // Required empty public constructor
        super(R.layout.fragment_mod_manager_main);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Button mInstallMrpackButton = view.findViewById(R.id.install_mrpack_button);

        mInstallMrpackButton.setOnClickListener(v -> runMrpackInstaller());

    }

    public static ModManagerMain newInstance(String param1, String param2) {
        ModManagerMain fragment = new ModManagerMain();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mod_manager_main, container, false);
    }

    private void runMrpackInstaller() {
        if (ProgressKeeper.getTaskCount() == 0)
            Tools.installModpack(requireActivity());
        else
            Toast.makeText(requireContext(), R.string.tasks_ongoing, Toast.LENGTH_LONG).show();
    }

}