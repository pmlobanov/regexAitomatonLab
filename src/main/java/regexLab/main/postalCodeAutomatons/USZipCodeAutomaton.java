package regexLab.main.postalCodeAutomatons;

import automaton.DFA;
import automaton.State;

import java.util.HashMap;
import java.util.Map;

public class USZipCodeAutomaton extends DFA {

    public USZipCodeAutomaton(){
        // 1. Сначала вызываем конструктор суперкласса с начальным состоянием
        super(new State("s0", false));

        // 2. Создаем все состояния и добавляем их в автомат
        Map<String, State> states = new HashMap<>();

        // Начальное состояние уже создано в конструкторе суперкласса
        states.put("s0", getStartState());

        // Создаем остальные состояния (s1-s9)
        for (int i = 1; i <= 21; i++) {
            if (i != 18){
                State state = new State("s" + i, false);
                states.put("s" + i, state);
                addState(state);
            }

        }

        // Создаем состояние s10 (принимающее)
        State s18 = new State("s18", true);
        states.put("s18", s18);
        addState(s18);

        // Создаем состояние s10 (принимающее)
        State s22 = new State("s22", true);
        states.put("s22", s22);
        addState(s22);

        // 3. Добавляем переходы между состояниями
        // s0 переходы
        addTransitions(states.get("s0"), Map.of(
                '8', states.get("s1"),
                '9', states.get("s2"),
                '7', states.get("s3"),
                '6', states.get("s4"),
                '4', states.get("s5"),
                '3', states.get("s6"),
                '2', states.get("s7"),
                '1', states.get("s8"),
                '0', states.get("s8"),
                '5', states.get("s8")
        ));

        // s1 переходы
        addTransitions(states.get("s1"), Map.of(
                '8', states.get("s11"),
                '0', states.get("s15"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '9', states.get("s15")
        ));

        // s2 переходы
        addTransitions(states.get("s2"), Map.of(
                '0', states.get("s15"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s3 переходы
        addTransitions(states.get("s3"), Map.of(
                '0', states.get("s15"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s4 переходы
        addTransitions(states.get("s4"), Map.of(
                '0', states.get("s15"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s5 переходы
        addTransitions(states.get("s5"), Map.of(
                '0', states.get("s15"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s6 переходы
        addTransitions(states.get("s6"), Map.of(
                '0', states.get("s15"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s7 переходы
        addTransitions(states.get("s7"), Map.of(
                '0', states.get("s15"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s8 переходы
        addTransitions(states.get("s8"), Map.of(
                '0', states.get("s15"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s9 переходы
        addTransitions(states.get("s9"), Map.of(
                '0', states.get("s12"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s15"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s10 переходы
        addTransitions(states.get("s10"), Map.of(
                '0', states.get("s12"),
                '1', states.get("s15"),
                '2', states.get("s15"),
                '3', states.get("s15"),
                '4', states.get("s15"),
                '5', states.get("s15"),
                '6', states.get("s13"),
                '7', states.get("s15"),
                '8', states.get("s15"),
                '9', states.get("s15")
        ));

        // s11 переходы
        addTransitions(states.get("s11"), Map.of(
                '0', states.get("s16"),
                '1', states.get("s16"),
                '2', states.get("s16"),
                '3', states.get("s16"),
                '4', states.get("s16"),
                '9', states.get("s16")
        ));

        // s12 переходы
        addTransitions(states.get("s12"), Map.of(
                '5', states.get("s16"),
                '6', states.get("s16"),
                '7', states.get("s16"),
                '8', states.get("s16"),
                '9', states.get("s16")
        ));

        // s13 переходы
        addTransitions(states.get("s13"), Map.of(
                '0', states.get("s14"),
                '1', states.get("s14"),
                '2', states.get("s14"),
                '3', states.get("s14"),
                '4', states.get("s14"),
                '5', states.get("s14"),
                '6', states.get("s14"),
                '7', states.get("s14")
        ));

        addTransitions(states.get("s14"), Map.of(
                '0', states.get("s17"),
                '1', states.get("s17"),
                '2', states.get("s17"),
                '3', states.get("s17"),
                '4', states.get("s17"),
                '5', states.get("s17"),
                '6', states.get("s17"),
                '7', states.get("s17"),
                '8', states.get("s17"),
                '9', states.get("s17")
        ));

        addTransitions(states.get("s15"), Map.of(
                '0', states.get("s16"),
                '1', states.get("s16"),
                '2', states.get("s16"),
                '3', states.get("s16"),
                '4', states.get("s16"),
                '5', states.get("s16"),
                '6', states.get("s16"),
                '7', states.get("s16"),
                '8', states.get("s16"),
                '9', states.get("s16")
        ));

        addTransitions(states.get("s16"), Map.of(
                '0', states.get("s17"),
                '1', states.get("s17"),
                '2', states.get("s17"),
                '3', states.get("s17"),
                '4', states.get("s17"),
                '5', states.get("s17"),
                '6', states.get("s17"),
                '7', states.get("s17"),
                '8', states.get("s17"),
                '9', states.get("s17")
        ));

        addTransitions(states.get("s17"), Map.of(
                '0', states.get("s18"),
                '1', states.get("s18"),
                '2', states.get("s18"),
                '3', states.get("s18"),
                '4', states.get("s18"),
                '5', states.get("s18"),
                '6', states.get("s18"),
                '7', states.get("s18"),
                '8', states.get("s18"),
                '9', states.get("s18")
        ));

        addTransitions(states.get("s18"), Map.of(
                '-', states.get("s19")
        ));

        addTransitions(states.get("s19"), Map.of(
                '0', states.get("s20"),
                '1', states.get("s20"),
                '2', states.get("s20"),
                '3', states.get("s20"),
                '4', states.get("s20"),
                '5', states.get("s20"),
                '6', states.get("s20"),
                '7', states.get("s20"),
                '8', states.get("s20"),
                '9', states.get("s20")
        ));

        addTransitions(states.get("s20"), Map.of(
                '0', states.get("s21"),
                '1', states.get("s21"),
                '2', states.get("s21"),
                '3', states.get("s21"),
                '4', states.get("s21"),
                '5', states.get("s21"),
                '6', states.get("s21"),
                '7', states.get("s21"),
                '8', states.get("s21"),
                '9', states.get("s21")
        ));

        addTransitions(states.get("s21"), Map.of(
                '0', states.get("s22"),
                '1', states.get("s22"),
                '2', states.get("s22"),
                '3', states.get("s22"),
                '4', states.get("s22"),
                '5', states.get("s22"),
                '6', states.get("s22"),
                '7', states.get("s22"),
                '8', states.get("s22"),
                '9', states.get("s22")
        ));




    }

}
