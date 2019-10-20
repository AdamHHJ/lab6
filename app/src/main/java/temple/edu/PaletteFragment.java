package temple.edu;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.Serializable;
import java.util.ArrayList;

public class PaletteFragment extends Fragment {


    private ColorAdapter adapter;
    private boolean first = true;
    private ArrayList<CustomColor> list;

    public  static PaletteFragment newInstance (ArrayList<CustomColor> colors){
        PaletteFragment paletteFragment = new PaletteFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("color",colors);
        paletteFragment.setArguments(bundle);
        return paletteFragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paletter,container,false);
        list = (ArrayList<CustomColor>) getArguments().getSerializable("color");
        adapter = new ColorAdapter(getActivity(), list);
        Spinner spinner=view. findViewById(R.id.spinner);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String color = list.get(i).getColor();
                listener.onItemSelected(color);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        return view;
    }

    public void addColorSelectListener(OnItemSelectedListener listener){
        this.listener = listener;
   }

    public interface OnItemSelectedListener{
        void onItemSelected(String colorHex);
    }

    private OnItemSelectedListener listener;
}
