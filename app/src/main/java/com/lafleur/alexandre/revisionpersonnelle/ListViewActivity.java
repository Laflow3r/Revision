package com.lafleur.alexandre.revisionpersonnelle;

import android.inputmethodservice.Keyboard;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    final private int[] names = {R.string.texte1,R.string.texte2,R.string.texte3,R.string.texte4 };
    final private int[] imageAdress = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground, R.drawable.ic_launcher_foreground };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        ArrayList<RowClass> listRow = new ArrayList<>();
        for (int i = 0; i < names.length ; i++)
        {
            listRow.add(new RowClass(  imageAdress[i], getResources().getString(names[i])));
        }

        ((ListView)findViewById(R.id.ListviewId)).setAdapter(new JourneeAdapter(listRow));
    }
    class JourneeAdapter extends ArrayAdapter<RowClass> {

        JourneeAdapter(List<RowClass> list) {
            super(ListViewActivity.this, R.layout.row, R.id.textView, list);
        }//ListeJour est l’activity principale et listeJournee mon ArrayList de Journee

        public View getView(int position, View convertView, ViewGroup parent) {
            JourneeWrapper wrapper;
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.row, null);
                wrapper = new JourneeWrapper(convertView);
                convertView.setTag(wrapper);
            } else
                wrapper = (JourneeWrapper) convertView.getTag();
            wrapper.setLaRow(getItem(position));
            return convertView;
        }
    }

    class JourneeWrapper {
        private TextView name = null;
        private ImageView face = null;
        private View row = null;

        JourneeWrapper(View row) {
            this.row = row;
        }

        public TextView getName() {
            if (name == null) name = (TextView) row.findViewById(R.id.textView);
            return name;
        }

        public ImageView getFace() {
            if (face == null) face = (ImageView) row.findViewById(R.id.imageView);
            return face;
        }

        public void setLaRow(final RowClass j) {
            getName().setText(j.getTexte());
            getFace().setImageResource(j.getAdresseImage());
            this.row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), j.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
