package net.accedegh.retrofitlibrary;

/**
 * Created by frank on 12/16/16.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import net.accedegh.retrofitlibrary.model.Movie;
/**
 * Created by frank on 12/13/16.
 */


public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {
    private List<Movie> movies;
    private Context context;
   // private Movie movie;

    public MoviesAdapter(Context applicationContext, List<Movie> movieArrayList) {
        this.context =applicationContext;
        this.movies=movieArrayList;
    }

    @Override
    public MoviesAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_movie, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MoviesAdapter.ViewHolder viewHolder, int i) {
        viewHolder.title.setText(movies.get(i).getTitle());
        viewHolder.actors.setText(movies.get(i).getActors());
        viewHolder.year.setText(movies.get(i).getYear());

        // This is how we use Picasso to load images from the internet.
       Picasso.with(context)
                .load(movies.get(i).getCover())
                //.placeholder(R.drawable.)
               .into(viewHolder.imageView);

        //viewHolder.imageView.setImageURI(movies.get(i).getCover());
    }
    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, year, actors;
        private ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            year = (TextView) view.findViewById(R.id.year);
            actors = (TextView) view.findViewById(R.id.actors);
            imageView= (ImageView) view.findViewById(R.id.cover);
        }
    }
    /* Within the RecyclerView.Adapter class */
    // Clean all elements of the recycler
    public void clear() {
        movies.clear();
        notifyDataSetChanged();
    }

    //RecyclerView mRecycler;
    // Add a list of ites
    public void addAll(List<Movie> mov) {
        movies.addAll(0,mov);
        notifyItemInserted(0);
        //mRecycler.smoothScrollToPosition(0);
        notifyDataSetChanged();
    }
}