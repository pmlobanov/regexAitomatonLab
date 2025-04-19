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
        for (int i = 1; i <= 10; i++) {
            // Только s10 будет принимающим состоянием
            State state = new State("s" + i, false);
            states.put("s" + i, state);
            addState(state);
        }

        // Создаем состояние s10 (принимающее)
        State s11 = new State("s11", true);
        states.put("s11", s11);
        addState(s11);

        // 3. Добавляем переходы между состояниями
        // s0 переходы
        addTransitions(states.get("s0"), Map.of(
                '1', states.get("s1"),
                '2', states.get("s2"),
                '3', states.get("s3"),
                '4', states.get("s4"),
                '5', states.get("s5"),
                '6', states.get("s6"),
                '7', states.get("s7"),
                '8', states.get("s8"),
                '9', states.get("s9")
        ));

        // s1 переходы
        addTransitions(states.get("s1"), Map.of(
                '0', states.get("s10"),
                '1', states.get("s10"),
                '7', states.get("s10"),
                '9', states.get("s10")
        ));


        // s1 переходы
        addTransitions(states.get("s2"), Map.of(
                '0', states.get("s10"),
                '1', states.get("s10"),
                '2', states.get("s10"),
                '3', states.get("s10"),
                '4', states.get("s10"),
                '5', states.get("s10"),
                '6', states.get("s10")
        ));

        // s2 переходы
        addTransitions(states.get("s3"), Map.of(
                '0', states.get("s10"),
                '1', states.get("s10"),
                '2', states.get("s10"),
                '3', states.get("s10"),
                '4', states.get("s10"),
                '5', states.get("s10"),
                '6', states.get("s10"),
                '7', states.get("s10")
        ));

        // s3 переходы
        addTransitions(states.get("s4"), Map.of(
                '0', states.get("s10"),
                '1', states.get("s10"),
                '2', states.get("s10"),
                '3', states.get("s10"),
                '4', states.get("s10"),
                '5', states.get("s10"),
                '6', states.get("s10"),
                '7', states.get("s10")
        ));

        // s4 переходы
        addTransitions(states.get("s5"), Map.of(
                '0', states.get("s10"),
                '1', states.get("s10"),
                '2', states.get("s10"),
                '3', states.get("s10"),
                '4', states.get("s10"),
                '5', states.get("s10"),
                '6', states.get("s10"),
                '7', states.get("s10"),
                '8', states.get("s10")
        ));

        // s5 переходы
        addTransitions(states.get("s6"), Map.of(
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

        // s6 переходы
        addTransitions(states.get("s7"), Map.of(
                '0', states.get("s10"),
                '1', states.get("s10"),
                '2', states.get("s10"),
                '3', states.get("s10"),
                '4', states.get("s10"),
                '5', states.get("s10"),
                '6', states.get("s10"),
                '8', states.get("s10")
        ));

        // s7 переходы
        addTransitions(states.get("s8"), Map.of(
                '0', states.get("s10"),
                '1', states.get("s10"),
                '2', states.get("s10"),
                '3', states.get("s10"),
                '4', states.get("s10"),
                '5', states.get("s10"),
                '6', states.get("s10"),
                '7', states.get("s10"),
                '8', states.get("s10")
        ));

        // s8 переходы
        addTransitions(states.get("s9"), Map.of(
                '0', states.get("s10")
        ));

            // s9 переходы
        addTransitions(states.get("s10"), Map.of(
                '0', states.get("s11"),
                '1', states.get("s11"),
                '2', states.get("s11"),
                '3', states.get("s11"),
                '4', states.get("s11"),
                '5', states.get("s11"),
                '6', states.get("s11"),
                '7', states.get("s11"),
                '8', states.get("s11"),
                '9', states.get("s11")
        ));
    }

}