package automaton;

import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;


/**
 * A Deterministic Finite Automaton (DFA) for recognizing patterns.
 */

public class DFA {
    private State startState;
    private Set<State> states;


    /**
     * Creates a new DFA with the given start state.
     *
     * @param startState The start state of the DFA
     */
    public DFA(State startState) {
        this.startState = startState;
        this.states = new HashSet<>();
        addState(startState);
    }

    /**
     * Adds a state to the DFA.
     *
     * @param state The state to add
     */
    public void addState(State state) {
        states.add(state);
    }

    /**
     * Checks if the given input string is accepted by this DFA.
     *
     * @param input The input string to check
     * @return true if the input is accepted, false otherwise
     */
    public boolean accepts(String input) {
        State currentState = startState;

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            currentState = currentState.getNextState(symbol);

            if (currentState == null) {
                return false; // No valid transition
            }
        }

        return currentState.isAccepting();
    }

    public Set<State> getStates() {
        return states;
    }

    public State getStartState() {
        return startState;
    }

    /**
     * Traces the execution of the DFA on the given input string.
     *
     * @param input The input string to trace
     * @return A string representation of the execution trace
     */
    public String trace(String input) {
        StringBuilder trace = new StringBuilder();
        State currentState = startState;

        trace.append("Start: ").append(currentState).append("\n");

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            State nextState = currentState.getNextState(symbol);

            if (nextState == null) {
                trace.append("Rejected at position ").append(i)
                        .append(": No transition from ").append(currentState)
                        .append(" on symbol '").append(symbol).append("'\n");
                return trace.toString();
            }

            trace.append("Read '").append(symbol).append("': ")
                    .append(currentState).append(" -> ").append(nextState).append("\n");

            currentState = nextState;
        }

        if (currentState.isAccepting()) {
            trace.append("Accepted in state ").append(currentState);
        } else {
            trace.append("Rejected: Ended in non-accepting state ").append(currentState);
        }

        return trace.toString();
    }

    // Вспомогательный метод для добавления нескольких переходов
    protected void addTransitions(State fromState, Map<Character, State> transitions) {
        for (Map.Entry<Character, State> entry : transitions.entrySet()) {
            fromState.addTransition(entry.getKey(), entry.getValue());
        }
    }

    public String generateAcceptableString() {
        Random random = new Random();
        StringBuilder result = new StringBuilder();
        State currentState = startState;
        while(!currentState.isAccepting()){
            //получаем список преерходов
            var transitions = currentState.getTransitions().keySet().toArray();
            // выбираем рандомное
            Character charToPut = (Character) transitions[(random.nextInt(transitions.length))];
            result.append(charToPut);
            currentState = currentState.getNextState(charToPut);
        }


        return result.toString();
    }
}
