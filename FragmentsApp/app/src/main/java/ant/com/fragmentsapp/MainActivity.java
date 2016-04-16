package ant.com.fragmentsapp;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import ant.com.fragmentsapp.fragments.CinemaFragment;
import ant.com.fragmentsapp.fragments.FirstFragment;
import ant.com.fragmentsapp.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity {

    private Drawer slidingDrawer;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        PrimaryDrawerItem item1 =
                new PrimaryDrawerItem()
                        .withName("Item 1")
                        .withIcon(R.mipmap.ic_launcher);

        PrimaryDrawerItem item2 =
                new PrimaryDrawerItem().withName("Cinema");

        PrimaryDrawerItem item3 =
                new PrimaryDrawerItem().withName("Item 3");

        PrimaryDrawerItem item4 =
                new PrimaryDrawerItem().withName("Item 4");

        PrimaryDrawerItem item5 =
                new PrimaryDrawerItem().withName("Item 5");

//        AccountHeader header =
//                new AccountHeaderBuilder()
//                        .withActivity(this)
//                        .withHeaderBackground(R.mipmap.ic_launcher)
//                        .addProfiles(new ProfileDrawerItem()
//                                .withName("Name")
//                                .withEmail("q@q.q")
//                                .withIcon(R.mipmap.ic_launcher))
//                        .build();


        slidingDrawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                //.withAccountHeader(header)
                .addDrawerItems(item1, item2, item3, item4, item5)
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (position == 1) {
                            //createFragment(new FirstFragment());
                        } else if (position == 2) {
                            createFragment(new CinemaFragment());
                        }
                        return false;
                    }
                })
                .build();

        slidingDrawer.setSelection(item2);

    }


    private void createFragment(Fragment fragment) {

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }

}
