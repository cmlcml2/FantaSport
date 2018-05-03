package com.android.efrei.fantasport.activity;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.android.efrei.fantasport.R;
import com.android.efrei.fantasport.model.Match;
import com.futuremind.recyclerviewfastscroll.SectionTitleProvider;

import java.util.ArrayList;
import java.util.List;



class MatchItemAdapter extends RecyclerView.Adapter<MatchItemAdapter.ViewHolder> implements SectionTitleProvider {

    private List<Match> matchs = new ArrayList<>();

    private Listener listener;

    private Context context;

    MatchItemAdapter(List<Match> items, Context context) {
        this.matchs = matchs;
        this.context = context;
    }


    /**
     * Création des ViewHolder, i.e. des espaces nécessaires à la partie visible à l'écran (dépend de la taille de l'écran)
     *
     * @param parent ViewGroup
     * @param viewType int
     * @return ViewHolder
     */
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LinearLayout layout = (LinearLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.match_item, parent, false);
        return new ViewHolder(layout);
    }

    void setListener(Listener listener) {
        this.listener = listener;
    }


    @Override
    public void onBindViewHolder(MatchItemAdapter.ViewHolder holder, int position) {
        final LinearLayout containerView = holder.containerView;

        final Match match = matchs.get(position);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public String getSectionTitle(int position) {
        //this String will be shown in a bubble for specified position
        return matchs.get(position).getJoueur1().substring(0, 1);
    }

    /**
     * Listener de clic sur l'Adapter. Permet de découpler l'Adapter du traitement et améliorer la réutilisation
     */
    interface Listener {
        void onClick(int position);
    }

    /**
     * ViewHolder du RecyclerView.Adapter
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout containerView;

        ViewHolder(LinearLayout view) {
            super(view);
            this.containerView = view;
        }
    }
}
