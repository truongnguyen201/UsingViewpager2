package topica.edu.vn.usingviewpager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ViewPager2Adapter extends RecyclerView.Adapter<ViewPager2Adapter.Viewholder> {
    int []imgHinh;

    public ViewPager2Adapter(int[] imgHinh) {
        this.imgHinh = imgHinh;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new Viewholder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
      holder.imgHinh.setImageResource(imgHinh[position]);
    }

    @Override
    public int getItemCount() {
        return imgHinh.length;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        ImageView imgHinh;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            imgHinh=itemView.findViewById(R.id.imgHinh);
        }
    }
}
