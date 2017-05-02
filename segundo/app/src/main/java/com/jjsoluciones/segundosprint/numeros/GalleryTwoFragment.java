package com.jjsoluciones.segundosprint.numeros;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jjsoluciones.segundosprint.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marili Arevalo on 02/03/2017.
 */

public class GalleryTwoFragment extends Fragment {
    private int currentIndex;
    private MediaPlayer mp [];
    private ArrayList<ImageItem>imageItems;
    private ArrayList<MediaPlayer>mediaPlayers;

    /*public void MediaPlayer (){
        mp[0] =MediaPlayer.create(this, R.raw.one);
    }*/
    private int[] photos = {
            R.drawable.uno,
            R.drawable.dos,
            R.drawable.tres,
            R.drawable.cuatro,
            R.drawable.cinco,
            R.drawable.seis,
            R.drawable.siete,
            R.drawable.ocho,
            R.drawable.nueve,
            R.drawable.diez,

    };

    private ViewPager vpGallery;
    private Context context;
    private GalleryManager galleryManager;

    public GalleryTwoFragment() {
        this.currentIndex = 0;
        this.imageItems = new ArrayList<>();
        /*this.mediaPlayers = new ArrayList<>();*/
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return  inflater.inflate(R.layout.main_fragment, container, false);

    }

    @Override
    public void onStart() {
        super.onStart();
        context = getActivity();
        FragmentManager fragmentManager = getFragmentManager();
        galleryManager = new GalleryManager(fragmentManager);
        vpGallery = (ViewPager)getView().findViewById(R.id.vp_Gallery);
        for ( int i= 0;i<photos.length;i++){
            galleryManager.addFragment(FragmentImage.newInstance(photos[i]));
            /*galleryManager.addFragment(FragmentImage.newInstance(mp[i]));*/
        }

        vpGallery.setAdapter(galleryManager);
        getActivity().onWindowFocusChanged(true);
    }

    public class GalleryManager extends FragmentPagerAdapter {
        List<Fragment> fragments;


        public GalleryManager(FragmentManager fm) {
            super(fm);
            fragments = new ArrayList<>();
        }

        public void addFragment(Fragment fragment){
            fragments.add(fragment);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    public static class FragmentImage extends Fragment {
        private static final String KEY_IMAGE = "image";
        private int image;

        public static FragmentImage newInstance(int image){
            FragmentImage fragmentImage = new FragmentImage();
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_IMAGE, image);
            fragmentImage.setArguments(bundle);
            fragmentImage.setRetainInstance(true);
            return fragmentImage;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments()!=null){
                image = getArguments().getInt(KEY_IMAGE);
            }
        }

        public FragmentImage() {
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.gallery_layout,container,false);
            ImageView ivPhoto = (ImageView) rootView.findViewById(R.id.iv_photo);
            ivPhoto.setImageResource(image);
            return rootView;
        }
    }

}
