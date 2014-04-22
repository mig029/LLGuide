package com.migliori.LSGuide.app;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardListView;

/**
 * Created by Anthony on 4/22/2014.
 */
public class EightKeysFragment extends Fragment {



        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_main, container, false);
            return view;

        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            String[] keys;

            keys = getActivity().getResources().getStringArray(R.array.keys);

            //card.setTitle(getString(R.string.eight_keys));

            ArrayList<Card> cards = new ArrayList<Card>();
            CardListView cardView = (CardListView) getActivity().findViewById(R.id.cardList);
            //cardView.setCard(card);
            int i = 1;
            for (String key : keys) {

                Card card = new Card(getActivity());
                CardHeader header = new CardHeader(getActivity());
                header.setTitle("Key " + i + ": ");
                card.setTitle(key);
                card.addCardHeader(header);
                card.setSwipeable(true);
                // cardView = (CardListView) getActivity().findViewById(R.id.carddemo);
                cards.add(card);
                i++;
            }
            CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(getActivity(), cards);
            CardListView listView = (CardListView) getActivity().findViewById(R.id.carddemo);
            if (listView != null) {
                listView.setAdapter(mCardArrayAdapter);
            }

        }



}
