package regexLab.main.postalCodeAutomatons;

import automaton.DFA;
import automaton.State;

import java.util.HashMap;
import java.util.Map;

public class RussianPostalCodeAutomaton extends DFA {
    public RussianPostalCodeAutomaton(){
        // 1. Сначала вызываем конструктор суперкласса с начальным состоянием
        super(new State("s0", false));

        // 2. Создаем все состояния и добавляем их в автомат
        Map<String, State> states = new HashMap<>();

        // Начальное состояние уже создано в конструкторе суперкласса
        states.put("s0", getStartState());

        // Создаем остальные состояния (s1-s9)
        for (int i = 1; i <= 28; i++) {
            // Только s10 будет принимающим состоянием
            State state = new State("s" + i, false);
            states.put("s" + i, state);
            addState(state);
        }

        // Создаем состояние s10 (принимающее)
        State s29 = new State("s29", true);
        states.put("s29", s29);
        addState(s29);

        // 3. Добавляем переходы между состояниями
        // s0 переходы
        addTransitions(states.get("s0"), Map.of(
                '1', states.get("s1"),
                '6', states.get("s2"),
                '3', states.get("s3"),
                '4', states.get("s4"),
                '2', states.get("s5")
        ));

        // s1 переходы
        addTransitions(states.get("s1"), Map.of(
                '0', states.get("s6"),
                '4', states.get("s7"),
                '5', states.get("s8"),
                '7', states.get("s9"),
                '8', states.get("s10"),
                '6', states.get("s19")
        ));

        // s2 переходы
        addTransitions(states.get("s2"), Map.of(
                '0', states.get("s8"),
                '3', states.get("s10"),
                '1', states.get("s19"),
                '2', states.get("s19"),
                '5', states.get("s19"),
                '6', states.get("s19"),
                '7', states.get("s19"),
                '8', states.get("s19"),
                '4', states.get("s20"),
                '9', states.get("s21")


        ));

        // s3 переходы
        addTransitions(states.get("s3"), Map.of(
                '0', states.get("s11"),
                '4', states.get("s12"),
                '6', states.get("s13"),
                '8', states.get("s14"),
                '9', states.get("s19"),
                '5', states.get("s19")
        ));

        // s4 переходы
        addTransitions(states.get("s4"), Map.of(
                '5', states.get("s8"),
                '4', states.get("s10"),
                '0', states.get("s15"),
                '1', states.get("s16"),
                '3', states.get("s17"),
                '6', states.get("s18"),
                '2', states.get("s19")
        ));

        // s5 переходы
        addTransitions(states.get("s5"), Map.of(
                '1', states.get("s22"),
                '4', states.get("s23"),
                '3', states.get("s24"),
                '9', states.get("s25")
        ));

        // s6 переходы
        addTransitions(states.get("s6"), Map.of(
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26"),
                '8', states.get("s26"),
                '9', states.get("s26")
        ));

        // s7 переходы
        addTransitions(states.get("s7"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26")
        ));

        // s8 переходы
        addTransitions(states.get("s8"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26"),
                '7', states.get("s26")
        ));

        // s9 переходы
        addTransitions(states.get("s9"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26"),
                '5', states.get("s26")
        ));

        // s10 переходы
        addTransitions(states.get("s10"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26")
        ));

        // s11 переходы
        addTransitions(states.get("s11"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26"),
                '7', states.get("s26"),
                '8', states.get("s26"),
                '9', states.get("s26")
        ));

        // s12 переходы
        addTransitions(states.get("s12"), Map.of(
                '4', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26"),
                '7', states.get("s26"),
                '8', states.get("s26"),
                '9', states.get("s26")
        ));

        // s13 переходы
        addTransitions(states.get("s13"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26"),
                '6', states.get("s26"),
                '7', states.get("s26"),
                '8', states.get("s26")
        ));

        // s14 переходы
        addTransitions(states.get("s14"), Map.of(
                '5', states.get("s26"),
                '6', states.get("s26")
        ));

        // s15 переходы
        addTransitions(states.get("s15"), Map.of(
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26")
        ));

        // s16 переходы
        addTransitions(states.get("s16"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26")
        ));

        // s17 переходы
        addTransitions(states.get("s17"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26")
        ));

        // s18 переходы
        addTransitions(states.get("s18"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26")
        ));

        // s19 переходы
        addTransitions(states.get("s19"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26"),
                '7', states.get("s26"),
                '8', states.get("s26"),
                '9', states.get("s26")
        ));

        // s20 переходы
        addTransitions(states.get("s20"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '4', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26"),
                '7', states.get("s26"),
                '8', states.get("s26"),
                '9', states.get("s26")
        ));

        // s21 переходы
        addTransitions(states.get("s21"), Map.of(
                '0', states.get("s26"),
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '4', states.get("s26")
        ));

        // s22 переходы
        addTransitions(states.get("s22"), Map.of(
                '4', states.get("s26"),
                '5', states.get("s26"),
                '6', states.get("s26")
        ));

        // s23 переходы
        addTransitions(states.get("s23"), Map.of(
                '1', states.get("s26"),
                '2', states.get("s26"),
                '3', states.get("s26"),
                '8', states.get("s26"),
                '9', states.get("s26")
        ));

        // s24 переходы
        addTransitions(states.get("s24"), Map.of(
                '6', states.get("s26"),
                '7', states.get("s26"),
                '8', states.get("s26")
        ));

        // s25 переходы
        addTransitions(states.get("s25"), Map.of(
                '5', states.get("s26"),
                '6', states.get("s26"),
                '7', states.get("s26"),
                '8', states.get("s26"),
                '9', states.get("s26")
        ));

        // s26 переходы
        addTransitions(states.get("s26"), Map.of(
                '0', states.get("s27"),
                '1', states.get("s27"),
                '2', states.get("s27"),
                '3', states.get("s27"),
                '4', states.get("s27"),
                '5', states.get("s27"),
                '6', states.get("s27"),
                '7', states.get("s27"),
                '8', states.get("s27"),
                '9', states.get("s27")
        ));

        // s27 переходы
        addTransitions(states.get("s27"), Map.of(
                '0', states.get("s28"),
                '1', states.get("s28"),
                '2', states.get("s28"),
                '3', states.get("s28"),
                '4', states.get("s28"),
                '5', states.get("s28"),
                '6', states.get("s28"),
                '7', states.get("s28"),
                '8', states.get("s28"),
                '9', states.get("s28")
        ));

        // s28 переходы
        addTransitions(states.get("s28"), Map.of(
                '0', states.get("s29"),
                '1', states.get("s29"),
                '2', states.get("s29"),
                '3', states.get("s29"),
                '4', states.get("s29"),
                '5', states.get("s29"),
                '6', states.get("s29"),
                '7', states.get("s29"),
                '8', states.get("s29"),
                '9', states.get("s29")
        ));

    }
}
