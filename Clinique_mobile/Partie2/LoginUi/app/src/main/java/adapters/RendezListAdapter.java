package adapters;

import android.content.Context;
import android.widget.*;
import entities.*;
import java.util.*;
import android.view.*;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.loginui.R;

public class RendezListAdapter extends ArrayAdapter<Rendez> {

    private Context context;
    private List<Rendez> rendezs;

    public RendezListAdapter(@NonNull Context context, List<Rendez> rendezs) {
        super(context, R.layout.rd_layout, rendezs);
        this.context = context;
        this.rendezs = rendezs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.rd_layout,parent, false);
        TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
        textViewName.setText(rendezs.get(position).getName());
        TextView textViewDate = (TextView) view.findViewById(R.id.textViewDate);
        textViewDate.setText(rendezs.get(position).getDate());
        TextView textViewDocteur = (TextView) view.findViewById(R.id.textViewDocteur);
        textViewDocteur.setText(rendezs.get(position).getEtat());
        return view;
    }
}
