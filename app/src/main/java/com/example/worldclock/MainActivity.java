package com.example.worldclock;

import android.icu.util.LocaleData;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.TextClock;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.time.LocalDate;
import java.util.TimeZone;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    public static Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = null;

            switch(getArguments().getInt(ARG_SECTION_NUMBER))
            {
                case 1:
                    View view = inflater.inflate(R.layout.fragment_first, container, false);
                    final TextView date = (TextView) view.findViewById(R.id.dateID);
                    TimeZone defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
                    Calendar cal = Calendar.getInstance();
                    Date dateD = cal.getTime();
                    String strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date.setText(strDate);
                    final AnalogClock aClock = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock.setVisibility(View.VISIBLE);
                                dClock.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock.setVisibility(View.INVISIBLE);
                                dClock.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 2:
                    view = inflater.inflate(R.layout.fragment_second, container, false);
                    final TextView date2 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("America/Los_Angeles"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date2.setText(strDate);
                    final AnalogClock aClock2 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock2 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock2.setVisibility(View.VISIBLE);
                                dClock2.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock2.setVisibility(View.INVISIBLE);
                                dClock2.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 3:
                    view = inflater.inflate(R.layout.fragment_third, container, false);
                    final TextView date3 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("America/Chicago"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date3.setText(strDate);
                    final AnalogClock aClock3 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock3 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock3.setVisibility(View.VISIBLE);
                                dClock3.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock3.setVisibility(View.INVISIBLE);
                                dClock3.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 4:
                    view = inflater.inflate(R.layout.fragment_fourth, container, false);
                    final TextView date4 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date4.setText(strDate);
                    final AnalogClock aClock4 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock4 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock4.setVisibility(View.VISIBLE);
                                dClock4.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock4.setVisibility(View.INVISIBLE);
                                dClock4.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 5:
                    view = inflater.inflate(R.layout.fragment_fifth, container, false);
                    final TextView date5 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("America/New_York"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date5.setText(strDate);
                    final AnalogClock aClock5 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock5 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock5.setVisibility(View.VISIBLE);
                                dClock5.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock5.setVisibility(View.INVISIBLE);
                                dClock5.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 6:
                    view = inflater.inflate(R.layout.fragment_sixth, container, false);
                    final TextView date6 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("Europe/Madrid"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date6.setText(strDate);
                    final AnalogClock aClock6 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock6 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock6.setVisibility(View.VISIBLE);
                                dClock6.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock6.setVisibility(View.INVISIBLE);
                                dClock6.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 7:
                    view = inflater.inflate(R.layout.fragment_seventh, container, false);
                    final TextView date7 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Hong_Kong"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date7.setText(strDate);
                    final AnalogClock aClock7 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock7 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock7.setVisibility(View.VISIBLE);
                                dClock7.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock7.setVisibility(View.INVISIBLE);
                                dClock7.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 8:
                    view = inflater.inflate(R.layout.fragment_eighth, container, false);
                    final TextView date8 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("Asia/Tokyo"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date8.setText(strDate);
                    final AnalogClock aClock8 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock8 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock8.setVisibility(View.VISIBLE);
                                dClock8.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock8.setVisibility(View.INVISIBLE);
                                dClock8.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 9:
                    view = inflater.inflate(R.layout.fragment_ninth, container, false);
                    final TextView date9 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("Brazil/East"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date9.setText(strDate);
                    final AnalogClock aClock9 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock9 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock9.setVisibility(View.VISIBLE);
                                dClock9.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock9.setVisibility(View.INVISIBLE);
                                dClock9.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
                case 10:
                    view = inflater.inflate(R.layout.fragment_tenth, container, false);
                    final TextView date10 = (TextView) view.findViewById(R.id.dateID);
                    defaultTz = TimeZone.getDefault();
                    TimeZone.setDefault(TimeZone.getTimeZone("Australia/Sydney"));
                    cal = Calendar.getInstance();
                    dateD = cal.getTime();
                    strDate = new SimpleDateFormat("MMM dd, yyyy").format(dateD);
                    date10.setText(strDate);
                    final AnalogClock aClock10 = (AnalogClock) view.findViewById(R.id.analogClock);
                    final TextClock dClock10 = (TextClock) view.findViewById(R.id.textClock);
                    button = (Button) view.findViewById(R.id.button);
                    button.setOnClickListener(new View.OnClickListener() {
                        int i = 0;
                        public void onClick(View v) {
                            if (i == 0) {
                                aClock10.setVisibility(View.VISIBLE);
                                dClock10.setVisibility(View.INVISIBLE);
                                i = 1;
                            }
                            else{
                                aClock10.setVisibility(View.INVISIBLE);
                                dClock10.setVisibility(View.VISIBLE);
                                i = 0;
                            }
                        }
                    });
                    rootView = view;
                    break;
            }

            //TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 10;
        }
    }
}
