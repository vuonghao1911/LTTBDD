package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DetailsShoesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DetailsShoesFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView tvTitle;
    private ImageView imgView;

    public DetailsShoesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DetailsShoesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DetailsShoesFragment newInstance(String param1, String param2) {
        DetailsShoesFragment fragment = new DetailsShoesFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_details_shoes, container, false);
        imgView = view.findViewById(R.id.idImgDe);
        tvTitle = view.findViewById(R.id.idDetails);
        Bundle bundle = getArguments();
     //   String title = getArguments().getString("title");
       // int img = getArguments().getInt("img");

        tvTitle.setText(bundle.getString("title"));
        imgView.setImageResource(bundle.getInt("img"));

        return  view;
    }
}