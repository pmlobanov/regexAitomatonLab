import automaton.DFA;
import org.junit.Test;
import regexLab.main.postalCodeAutomatons.IcelandPostalCodeAutomaton;
import regexLab.main.postalCodeAutomatons.RussianPostalCodeAutomaton;
import regexLab.main.postalCodeAutomatons.USZipCodeAutomaton;

import static org.junit.Assert.*;

public class PostalCodeAutomatonTest {

    // Тесты для исландских индексов (2-значные группы из первого изображения)
    @Test
    public void testIcelandPostalCodes() {
        DFA icelandDfa = new IcelandPostalCodeAutomaton();

        // Проверка валидных кодов по зонам
        assertTrue(icelandDfa.accepts("434"));  // Для группы 43.41
        assertTrue(icelandDfa.accepts("474"));  // Для группы 47.42
        assertTrue(icelandDfa.accepts("465"));  // Для группы 46.51
        assertTrue(icelandDfa.accepts("457"));  // Для группы 45.71
        assertTrue(icelandDfa.accepts("363"));  // Для группы 36.35

        // Проверка невалидных кодов
        assertFalse(icelandDfa.accepts("131")); // Слишком маленький
        assertFalse(icelandDfa.accepts("999")); // Слишком большой
        assertFalse(icelandDfa.accepts("12A")); // Недопустимые символы
    }

    // Тесты для российских индексов
    @Test
    public void testRussianPostalCodes() {
        DFA russiaDfa = new RussianPostalCodeAutomaton();

        // Московский регион (101xxx-135xxx)
        assertTrue(russiaDfa.accepts("101000")); // Москва, Кремль
        assertTrue(russiaDfa.accepts("125009")); // Москва, Тверская

        // Санкт-Петербург (190xxx-199xxx)
        assertTrue(russiaDfa.accepts("190000")); // СПб, Невский пр.

        // Новосибирск (630xxx)
        assertTrue(russiaDfa.accepts("630000"));

        // Невалидные коды
        assertFalse(russiaDfa.accepts("100000")); // Ниже минимального
        assertFalse(russiaDfa.accepts("999999")); // Выше максимального
        assertFalse(russiaDfa.accepts("12345"));  // Слишком короткий
    }

    // Тесты для американских ZIP-кодов (данные из второго изображения)
    @Test
    public void testUSZipCodes() {
        DFA usDfa = new USZipCodeAutomaton();

        // Основные 5-значные коды
        assertTrue(usDfa.accepts("98020"));  // Для диапазона 980–994
        assertTrue(usDfa.accepts("83201"));  // Для 832–839 (Айдахо)
        assertTrue(usDfa.accepts("55016"));  // Для 550–567 (Миннесота)

        // ZIP+4 форматы
        assertTrue(usDfa.accepts("96950-1234")); // Для PW/FM/MH/MP/GU
        assertTrue(usDfa.accepts("96799"));      // AS (Американское Самоа)

        // Невалидные коды
        assertFalse(usDfa.accepts("00000"));     // Несуществующий
        assertFalse(usDfa.accepts("99999-12345")); // Слишком длинный
        assertFalse(usDfa.accepts("ABCDE"));     // Буквы вместо цифр
    }

    // Тесты граничных значений
    @Test
    public void testBoundaryValues() {
        DFA icelandDfa = new IcelandPostalCodeAutomaton();
        DFA russiaDfa = new RussianPostalCodeAutomaton();
        DFA usDfa = new USZipCodeAutomaton();

        // Исландия
        assertTrue(icelandDfa.accepts("101"));  // Минимальный валидный
        assertTrue(icelandDfa.accepts("902"));  // Максимальный валидный
        assertFalse(icelandDfa.accepts("000")); // Ниже минимального
        assertFalse(icelandDfa.accepts("912")); // Выше максимального

        // Россия
        assertTrue(russiaDfa.accepts("101000")); // Минимальный валидный
        assertFalse(russiaDfa.accepts("901999")); // Максимальный валидный

        // США
        assertTrue(usDfa.accepts("00501"));     // Минимальный валидный
        assertTrue(usDfa.accepts("99950"));     // Максимальный валидный
    }
}