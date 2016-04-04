package esi.dz.myapplication;


import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by pc on 12/03/2016.
 */
public class PlaceholderFragment extends Fragment  {
    ListView    listView ;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_main, null);
            listView = (ListView) v.findViewById(R.id.listView);
        CutomAdapter   cutomAdapter = new CutomAdapter(getActivity(),getBookList("Base de donnees&Systeme"));
        listView.setAdapter(cutomAdapter);
        return v;
    }



    public List<Book> getBookList(String category) {
        List<Book> listBook = getBookList();
        List<Book> listFiltred = new ArrayList<Book>();
        for(int i=0;i<listBook.size();i++) {
            Book book = listBook.get(i);
            if (book.getCategory().equals(category)) {
                listFiltred.add(book);
            }
        }
        return listFiltred;
    }



    public List<Book> getBookList() {
        String[] listSummary = getResources().getStringArray(R.array.summary);
        List<Book> bookList = new ArrayList<Book>();
        // le 1er livre
        Book book = new Book();
        book.setTitle("Design Patterns in Java");
        List authors = new ArrayList();
        authors.add("Steven John Metsker");
        authors.add("William C. Wake");
        book.setAuthors(authors);
        book.setEditor("Addison-Wesley Professional");
        book.setIconCover(R.drawable.ic_dpjava);
        book.setCover(R.drawable.ic_dpjavacover);
        book.setYear("2006");
        book.setSummary(listSummary[0]);
        book.setCategory("Genie logiciel");
        bookList.add(book);
        // le 2eme livre
        book = new Book();
        //book.setTitle("UML 2.0 in a Nutshell");
        book.setTitle("UML 2.0 in a Nutshell UML 2.0");
        authors = new ArrayList();
        authors.add("Dan Pilone");
        authors.add("Neil Pitman");
        book.setAuthors(authors);
        book.setEditor("OReilly");
        book.setIconCover(R.drawable.ic_uml_2);
        book.setCover(R.drawable.ic_uml_2cover);
        book.setYear("2005");
        book.setCategory("Genie logiciel");
        book.setSummary(listSummary[1]);

        bookList.add(book);
        // le 3eme livre
        book = new Book();
        book.setTitle("Microsoft SQL Server 2012 Pocket Consultant");
        authors = new ArrayList();
        authors.add("William R. Stanek");
        book.setAuthors(authors);
        book.setEditor("Microsoft Press");
        book.setIconCover(R.drawable.ic_sqlpc);
        book.setCover(R.drawable.ic_sqlpc_cover);
        book.setYear("2012");
        book.setSummary(listSummary[2]);
        book.setCategory("Base de donnees&Systeme");
        bookList.add(book);
        // le 4ème livre
        book = new Book();
        book.setTitle("Android UI Fundamentals: Develop & Design");
        authors = new ArrayList();
        authors.add("Jason Ostrander");
        book.setAuthors(authors);
        book.setEditor("Peachpit Press");
        book.setIconCover(R.drawable.ic_androidfd);
        book.setCover(R.drawable.ic_androidfdcover);
        book.setYear("2012");
        book.setSummary(listSummary[3]);
        book.setCategory("Programmation");
        bookList.add(book);
        // le 5ème livre
        book = new Book();
        book.setTitle("Programming in Objective-C");
        authors = new ArrayList();
        authors.add("Stephen Kochan");
        book.setAuthors(authors);
        book.setEditor("OReilly Media, Inc.");
        book.setIconCover(R.drawable.ic_objectivec);
        book.setCover(R.drawable.ic_objectivecover);
        book.setYear("2012");
        book.setSummary(listSummary[4]);
        book.setCategory("Programmation");
        bookList.add(book);
        // le 6 ème livre
        book = new Book();
        book.setTitle("Learning Agile");
        authors = new ArrayList();
        authors.add("Andrew Stellman");
        authors.add("Jennifer Greene");
        book.setAuthors(authors);
        book.setEditor("Kindle Edition");
        book.setIconCover(R.drawable.ic_agile);
        book.setCover(R.drawable.ic_agilecovrer);
        book.setYear("2014");
        book.setSummary(listSummary[5]);
        book.setCategory("Genie logiciel");
        bookList.add(book);
        // le 7 ème livre
        book = new Book();
        book.setTitle("Learning the UNIX Operating System");
        authors = new ArrayList();
        authors.add("Jerry Peek");
        authors.add("Grace T-Gonguet");
        authors.add("John Strang");
        book.setAuthors(authors);
        book.setEditor("OReilly Media, Inc.");
        book.setIconCover(R.drawable.ic_unixicon);
        book.setCover(R.drawable.ic_unixicover);
        book.setYear("2002");
        book.setSummary(listSummary[6]);
        book.setCategory("Base de donnees&Systeme");
        bookList.add(book);
        return bookList;
    }

/*
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            cutomAdapter.getFilter().filter("OReilly");
        }
        else if (id == R.id.nav_gallery) {
          cutomAdapter.getFilter().filter("Microsoft Press");

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }
        DrawerLayout drawer = (DrawerLayout) getActivity().findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("message","Activity Created");
    }
*/


}
