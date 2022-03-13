package topica.edu.vn.usingviewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    ViewPager2 vp_vertical,vp_horiontal;
    int []img={R.drawable.hinh2,R.drawable.hinh3,R.drawable.light,
            R.drawable.lightoff,R.drawable.hinh2,R.drawable.hinh3,R.drawable.light,R.drawable.lightoff,R.drawable.hinh2};
    ViewPager2Adapter viewPager2Adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp_vertical=findViewById(R.id.vp_verticle);
        vp_horiontal=findViewById(R.id.vp_horizontal);
        viewPager2Adapter=new ViewPager2Adapter(img);

        vp_vertical.setAdapter(viewPager2Adapter);

        vp_horiontal.setClipToPadding(false);

        vp_horiontal.setClipChildren(false);

        vp_horiontal.setOffscreenPageLimit(3);

        vp_horiontal.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        vp_horiontal.setAdapter(viewPager2Adapter);

        CompositePageTransformer transformer=new CompositePageTransformer();

        transformer.addTransformer(new MarginPageTransformer(8));

        transformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                Float v=1-Math.abs(position);
                page.setScaleY(0.8f+v*0.2f);
            }
        });
        vp_horiontal.setPageTransformer(transformer);
    }
}