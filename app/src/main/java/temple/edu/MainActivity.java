package temple.edu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnItemSelectedListener {

    private CanvasFragment canvasFragment;
    private PaletteFragment paletteFragment;
    private ArrayList<CustomColor> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addColor();
        paletteFragment = PaletteFragment.newInstance(list);
        canvasFragment = CanvasFragment.newInstance();

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_palette,paletteFragment )
                .add(R.id.fragment_canvas, canvasFragment)
                .commit();
        paletteFragment.addColorSelectListener(this);
    }
    private void addColor() {
        list.add(new CustomColor(getString(R.string.white),"#FFFFFF"));
        list.add(new CustomColor(getString(R.string.blue),"#0000ff"));
        list.add(new CustomColor(getString(R.string.red),"#ff0000"));
        list.add(new CustomColor(getString(R.string.yellow),"#ffff00"));
        list.add(new CustomColor(getString(R.string.magenta),"#ff00ff"));
        list.add(new CustomColor(getString(R.string.lig),"#cccccc"));
        list.add(new CustomColor(getString(R.string.green),"#00ff00"));
        list.add(new CustomColor(getString(R.string.na),"#FFDEAD"));
        list.add(new CustomColor(getString(R.string.greenyellow),"#ADFF2F"));

    }

    @Override
    public void onItemSelected(String colorHex) {
        canvasFragment.setBackgroundColor(colorHex);
    }


}
