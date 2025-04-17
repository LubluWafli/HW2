package com.example.hw2;

import static android.app.PendingIntent.getActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;

import com.example.hw2.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    byte choosenOperation = 0;
    double firstNum = 0;
    double temp = 0;
    private ActivityMainBinding binding;
    
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putString("textTabloOld", (String) binding.tablo.getText());
        savedInstanceState.putByte("choosenOperationOld", choosenOperation);
        savedInstanceState.putDouble("firstNumOld", firstNum);
        savedInstanceState.putDouble("tempOld", temp);
        super.onSaveInstanceState(savedInstanceState);
    }
    
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String textTabloOld = savedInstanceState.getString("textTabloOld");
        choosenOperation = savedInstanceState.getByte("choosenOperationOld");
        firstNum = savedInstanceState.getDouble("firstNumOld");
        temp = savedInstanceState.getDouble("tempOld");
        binding.tablo.setText(textTabloOld);
    }
    
    public static class MyDialogFragment extends DialogFragment {
        @Override
        @NonNull
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Важное сообщение!")
                    .setMessage("Делить на ноль нельзя!!!")
                    .setPositiveButton("Понял, извините", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
            return builder.create();
        }
    }
        
        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            View view = binding.getRoot();
            setContentView(view);
            binding.tablo.setText("");
            
            binding.buttonPlusMinus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Log.w("myApp", String.valueOf(binding.tablo.getText().charAt(0)));
                    if (binding.tablo.getText() != "") {
                        if (String.valueOf(binding.tablo.getText().charAt(0)).equals("-")) {
                            String textTemp = (String) binding.tablo.getText();
                            textTemp = textTemp.substring(1);
                            binding.tablo.setText(textTemp);
                        } else {
                            binding.tablo.setText("-" + binding.tablo.getText());
                        }
                    }
                    
                    
                }
            });
            
            binding.buttonClear.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText("");
                    firstNum = 0;
                    choosenOperation = 0;
                }
            });
            
            binding.button0.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "0");
                }
            });
            
            binding.button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "1");
                }
            });
            
            binding.button2.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "2");
                }
            });
            
            binding.button3.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "3");
                }
            });
            
            binding.button4.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "4");
                }
            });
            
            binding.button5.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "5");
                }
            });
            
            binding.button6.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "6");
                }
            });
            
            binding.button7.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "7");
                }
            });
            
            binding.button8.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "8");
                }
            });
            
            binding.button9.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + "9");
                }
            });
            
            binding.buttonEq.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (choosenOperation != 0 & binding.tablo.getText() != "") {
                        Log.w("myApp", "ВЫБРАННАЯ ОПЕРАЦИЯ");
                        Log.w("myApp", String.valueOf(choosenOperation));
                        double temp = 0;
                        temp = Double.parseDouble((String) binding.tablo.getText());
                        switch (choosenOperation) {
                            case (1): {
                                firstNum += temp;
                                Log.w("myApp", "Зашел в case 1");
                                break;
                            }
                            case (2): {
                                firstNum -= temp;
                                Log.w("myApp", "Зашел в case 2");
                                break;
                            }
                            case (3): {
                                firstNum *= temp;
                                Log.w("myApp", "Зашел в case 3");
                                break;
                            }
                            case (4): {
                                if (temp == 0) {
                                    FragmentManager manager = getSupportFragmentManager();
                                    MyDialogFragment myDialogFragment = new MyDialogFragment();
                                    myDialogFragment.show(manager, "myDialog");
                                    firstNum = 0;
                                    break;
                                }
                                firstNum /= temp;
                                Log.w("myApp", "Зашел в case 4");
                                break;
                            }
                        }
                        binding.tablo.setText(String.valueOf(firstNum));
                        choosenOperation = 0;
                        firstNum = 0;
                        temp = 0;
                    }
                }
            });
            
            binding.buttonPlus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (binding.tablo.getText() != "") {
                        choosenOperation = 1;
                        firstNum = Double.parseDouble((String) binding.tablo.getText());
                        binding.tablo.setText("");
                    }
                }
            });
            
            binding.buttonMinus.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (binding.tablo.getText() != "") {
                        choosenOperation = 2;
                        firstNum = Double.parseDouble((String) binding.tablo.getText());
                        binding.tablo.setText("");
                    }
                }
            });
            
            binding.buttonMult.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (binding.tablo.getText() != "") {
                        choosenOperation = 3;
                        firstNum = Double.parseDouble((String) binding.tablo.getText());
                        binding.tablo.setText("");
                    }
                }
            });
            
            binding.buttonDiv.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (binding.tablo.getText() != "") {
                        choosenOperation = 4;
                        firstNum = Double.parseDouble((String) binding.tablo.getText());
                        binding.tablo.setText("");
                    }
                }
            });
            
            binding.buttonDot.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    binding.tablo.setText(binding.tablo.getText() + ".");
                }
            });
            
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, binding.drawerLayout, binding.toolbar, R.string.nav_open, R.string.nav_close);
            binding.drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
            binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    // Handle the selected item based on its ID
                    if (item.getItemId() == R.id.calculator) {
                    
                    }
                    
                    if (item.getItemId() == R.id.about) {
                        Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                        startActivity(intent);
                    }
                    binding.drawerLayout.closeDrawers();
                    return true;
                }
            });
            
            
            getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {
                    if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                        binding.drawerLayout.closeDrawer(GravityCompat.START);
                    } else {
                        finish();
                    }
                }
            });
        }
    }