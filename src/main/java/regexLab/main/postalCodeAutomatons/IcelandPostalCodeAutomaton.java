package regexLab.main.postalCodeAutomatons;

import automaton.DFA;
import automaton.State;

import java.util.HashMap;
import java.util.Map;


//класс обертка для исландского автомата.
public class IcelandPostalCodeAutomaton extends DFA {

    public IcelandPostalCodeAutomaton() {
        // 1. Сначала вызываем конструктор суперкласса с начальным состоянием
        super(new State("s0", false));

        // 2. Создаем все состояния и добавляем их в автомат
        Map<String, State> states = new HashMap<>();

        // Начальное состояние уже создано в конструкторе суперкласса
        states.put("s0", getStartState());

        // Создаем остальные состояния (s1-s9)
        for (int i = 1; i <= 9; i++) {
            // Только s10 будет принимающим состоянием
            State state = new State("s" + i, false);
            states.put("s" + i, state);
            addState(state);
        }

        // Создаем состояние s10 (принимающее)
        State s10 = new State("s10", true);
        states.put("s10", s10);
        addState(s10);

        // 3. Добавляем переходы между состояниями
        // s0 переходы
        addTransitions(states.get("s0"), Map.of(
                '2', states.get("s1"),
                '3', states.get("s2"),
                '4', states.get("s3"),
                '5', states.get("s4"),
                '6', states.get("s5"),
                '7', states.get("s6"),
                '8', states.get("s7"),
                '9', states.get("s8")
        ));

        // s1 переходы
        addTransitions(states.get("s1"), Map.of(
                '0', states.get("s9"),
                '1', states.get("s9"),
                '2', states.get("s9"),
                '3', states.get("s9"),
                '4', states.get("s9"),
                '5', states.get("s9"),
                '6', states.get("s9")
        ));

        // s2 переходы
        addTransitions(states.get("s2"), Map.of(
                '0', states.get("s9"),
                '1', states.get("s9"),
                '2', states.get("s9"),
                '3', states.get("s9"),
                '4', states.get("s9"),
                '5', states.get("s9"),
                '6', states.get("s9"),
                '7', states.get("s9")
        ));

        // s3 переходы
        addTransitions(states.get("s3"), Map.of(
                '0', states.get("s9"),
                '1', states.get("s9"),
                '2', states.get("s9"),
                '3', states.get("s9"),
                '4', states.get("s9"),
                '5', states.get("s9"),
                '6', states.get("s9"),
                '7', states.get("s9")
        ));

        // s4 переходы
        addTransitions(states.get("s4"), Map.of(
                '0', states.get("s9"),
                '1', states.get("s9"),
                '2', states.get("s9"),
                '3', states.get("s9"),
                '4', states.get("s9"),
                '5', states.get("s9"),
                '6', states.get("s9"),
                '7', states.get("s9"),
                '8', states.get("s9")
        ));

        // s5 переходы
        addTransitions(states.get("s5"), Map.of(
                '0', states.get("s9"),
                '1', states.get("s9"),
                '2', states.get("s9"),
                '3', states.get("s9"),
                '4', states.get("s9"),
                '5', states.get("s9"),
                '6', states.get("s9"),
                '7', states.get("s9"),
                '8', states.get("s9"),
                '9', states.get("s9")
        ));

        // s6 переходы
        addTransitions(states.get("s6"), Map.of(
                '0', states.get("s9"),
                '1', states.get("s9"),
                '2', states.get("s9"),
                '3', states.get("s9"),
                '4', states.get("s9"),
                '5', states.get("s9"),
                '6', states.get("s9"),
                '8', states.get("s9")
        ));

        // s7 переходы
        addTransitions(states.get("s7"), Map.of(
                '0', states.get("s9"),
                '1', states.get("s9"),
                '2', states.get("s9"),
                '3', states.get("s9"),
                '4', states.get("s9"),
                '5', states.get("s9"),
                '6', states.get("s9"),
                '7', states.get("s9"),
                '8', states.get("s9")
        ));

        // s8 переходы
        addTransitions(states.get("s8"), Map.of(
                '0', states.get("s9")
        ));

        // s9 переходы
        addTransitions(states.get("s9"), Map.of(
                '0', states.get("s10"),
                '1', states.get("s10"),
                '2', states.get("s10"),
                '3', states.get("s10"),
                '4', states.get("s10"),
                '5', states.get("s10"),
                '6', states.get("s10"),
                '7', states.get("s10"),
                '8', states.get("s10"),
                '9', states.get("s10")
        ));
    }

}