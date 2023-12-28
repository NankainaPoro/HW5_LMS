package vakulenko.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);

        // Создание сущностей билетов
        Ticket adultTicket = new Ticket("Молодой взрослый", 35);
        Ticket childTicket = new Ticket("Ребенок", 35 * 0.5); // Детский билет со скидкой 50%
        Ticket pensionerTicket = new Ticket("Пенсионер", 35 * 0.55); // Пенсионерский билет со скидкой 45%

        // Расчет общей стоимости билетов
        double totalCost = calculateTotalCost(adultTicket, childTicket, pensionerTicket);

        // Вывод результатов на экран
        resultTextView.setText("Общая стоимость билетов: " + totalCost + " монет");
    }

    private double calculateTotalCost(Ticket... tickets) {
        // Расчет общей стоимости билетов
        double totalCost = 0;
        for (Ticket ticket : tickets) {
            totalCost += ticket.getCost();
        }
        return totalCost;
    }

    // Класс для представления сущности билета
    private static class Ticket {
        private String type; // Тип билета (Молодой взрослый, Ребенок, Пенсионер)
        private double cost; // Стоимость билета

        public Ticket(String type, double cost) {
            this.type = type;
            this.cost = cost;
        }

        public String getType() {
            return type;
        }

        public double getCost() {
            return cost;
        }
    }
}