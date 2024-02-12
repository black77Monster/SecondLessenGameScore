package com.example.secondlessengamescore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // поля
    private TextView score; // табло для вывода счёта игры
    private Button foxTeam, crowTeam; // кнопки команд
    private int countFox = 0, countCrow = 0; // счётчики счёта команд

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // привязка к полям
        score = findViewById(R.id.score);
        foxTeam = findViewById(R.id.foxTeam);
        crowTeam = findViewById(R.id.crowTeam);

        // обработка нажатия кнопок
        foxTeam.setOnClickListener(listener);
        crowTeam.setOnClickListener(listener);
    }

    // запуск активности
    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText( this, "Запуск активности", Toast.LENGTH_SHORT).show();
    }

    // открытие взаимодействие с активностью
    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText( this, "Открытие взаимодействия с активностью", Toast.LENGTH_SHORT).show();
    }

    // отзыв взаимодействие с активностью
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText( this, "Отзыв взаимодействия с активностью", Toast.LENGTH_SHORT).show();
    }

    // скрытие активности
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText( this, "Скрытие активности", Toast.LENGTH_SHORT).show();
    }

    // уничтожение активности
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText( this, "Уничтожение активности", Toast.LENGTH_SHORT).show();
    }

    // метод сохранения данных
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("fox", countFox); // сохранение данных очков команды лисы
        outState.putInt("crow", countCrow); // сохранение данных очков команды вороны
    }

    // метод извлечения данных при создании активности
    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        countFox = savedInstanceState.getInt( "fox"); // сохранение данных очков команды лисы
        countCrow = savedInstanceState.getInt( "crow"); // сохранение данных очков команды вороны
        // вывод данных на экран смартфона
        score.setText(String.format("%02d", countFox) + " : " + String.format("%02d", countCrow));
    }

    // определение слушателя
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        protected void finalize() throws Throwable {
            super.finalize();
        }

        @Override
        public void onClick(View view) {
            // обработка счётчиков
            switch (view.getId()) {
                case R.id.foxTeam:
                    countFox++;
                    break;
                case R.id.crowTeam:
                    countCrow++;
                    break;
            }
            // вывод данных на экран смартфона
            score.setText(String.format("%02d", countFox) + " : " + String.format("%02d", countCrow));

        }
    };
}
