package temple.edu;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CanvasFragment extends Fragment {

    public  static CanvasFragment newInstance (){
        return new CanvasFragment();
    }
    private LinearLayout llRoot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_canvas,container,false);
        llRoot = view.findViewById(R.id.ll_root);
        return view;

    }

    public void setBackgroundColor(String colorHex) {
        llRoot.setBackgroundColor(Color.parseColor(colorHex));
    }
}
