package jugar.mcm.edu.ph.herogame2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // XML TO JAVA
        final EditText callLevel = findViewById(R.id.heroLevel);
        TextView callLevelCheck = findViewById(R.id.heroLevelCheck);
        TextView callName = findViewById(R.id.heroName);
        TextView callClass = findViewById(R.id.heroClass);
        TextView callID = findViewById(R.id.heroID);

        final TextView callHP1 = findViewById(R.id.health1);
        final TextView callHP2 = findViewById(R.id.health2);
        final TextView callMP1 = findViewById(R.id.mana1);
        final TextView callMP2 = findViewById(R.id.mana2);

        final TextView callStr = findViewById(R.id.strength);
        final TextView callAgi = findViewById(R.id.agility);
        final TextView callInt = findViewById(R.id.intelligence);

        final TextView callAttackDamageMin = findViewById(R.id.attackDamageMin);
        final TextView callAttackDamageMax = findViewById(R.id.attackDamageMax);
        final TextView callSpellDamage = findViewById(R.id.spellDamage);

        // CONSTRUCTOR
        String hero_class = "Agility";
        String name = "Juggernaut";
        int id = 2018102602;
        int level = 1;
        double strength = 20;
        double agility = 34;
        double intelligence = 14;

        final Hero h1 = new Hero(hero_class, name, id, level, strength, agility, intelligence);

        // GETTERS & SETTERS
        h1.setHeroClass("Agility");
        callClass.setText(h1.getHeroClass());

        h1.setHeroName("Juggernaut");
        callName.setText(h1.getHeroName());

        h1.setHeroID(2018102602);
        callID.setText(String.valueOf(h1.getHeroID()));

        h1.setHeroLevel(1);
        callLevel.setText(String.valueOf(h1.getHeroLevel()));

        h1.heroStat(20, 34, 14);
        callStr.setText(String.valueOf((Math.round(h1.computeStrength()))));
        callAgi.setText(String.valueOf(Math.round(h1.computeAgility())));
        callInt.setText(String.valueOf(Math.round(h1.computeIntelligence())));

        callHP1.setText(String.valueOf(Math.round(h1.computeHealth())));
        callHP2.setText(String.valueOf(Math.round(h1.computeHealth())));
        callMP1.setText(String.valueOf(Math.round(h1.computeMana())));
        callMP2.setText(String.valueOf(Math.round(h1.computeMana())));

        callAttackDamageMin.setText(String.valueOf(Math.round(h1.computePhysicalDamageMin())));
        callAttackDamageMax.setText(String.valueOf(Math.round(h1.computePhysicalDamageMax())));
        callSpellDamage.setText(String.valueOf(Math.round(h1.computeMagicDamage())));

        callLevelCheck.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int i = Integer.parseInt(String.valueOf(callLevel.getText()));
                        h1.setHeroLevel(i);
                        callLevel.setText(String.valueOf(h1.getHeroLevel()));

                        if ((h1.getHeroLevel() >= 1) && (h1.getHeroLevel() <= 30)) {
                            h1.heroStat(20, 34, 14);
                            callStr.setText(String.valueOf((Math.round(h1.computeStrength()))));
                            callAgi.setText(String.valueOf(Math.round(h1.computeAgility())));
                            callInt.setText(String.valueOf(Math.round(h1.computeIntelligence())));

                            callHP1.setText(String.valueOf(Math.round(h1.computeHealth())));
                            callHP2.setText(String.valueOf(Math.round(h1.computeHealth())));
                            callMP1.setText(String.valueOf(Math.round(h1.computeMana())));
                            callMP2.setText(String.valueOf(Math.round(h1.computeMana())));

                            callAttackDamageMin.setText(String.valueOf(Math.round(h1.computePhysicalDamageMin())));
                            callAttackDamageMax.setText(String.valueOf(Math.round(h1.computePhysicalDamageMax())));
                            callSpellDamage.setText(String.valueOf(Math.round(h1.computeMagicDamage())));
                        } else {
                            Toast.makeText(MainActivity.this,
                                    "Invalid level value",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );

    }
}
