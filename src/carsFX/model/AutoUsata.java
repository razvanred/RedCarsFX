package carsFX.model;

import java.time.LocalDate;

public class AutoUsata extends Auto {

    private LocalDate date;

    public AutoUsata(final Marca marca, final String modello, final Motore motore, final Tipo tipo, final int price, final LocalDate date) {
        super(marca, modello, motore, tipo, price);
        this.date=date;
    }

    public LocalDate getLocalDate(){
        return date;
    }
}
