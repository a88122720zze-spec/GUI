import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class toJapaneseTest {

    toJapanese jp = new toJapanese();

    @Test
    void translateTest1() {
        String[] ts = jp.translate(null, "a");
        assertEquals("あ", ts[0]);
        assertEquals("", ts[1]);
    }

    @Test
    void translateTest2() {
        String[] ts = jp.translate(null, "3");
        assertEquals("３", ts[0]);
        assertEquals("", ts[1]);
    }

    @Test
    void translateTest3() {
        String[] ts = jp.translate(null, "(");
        assertEquals("（", ts[0]);
        assertEquals("", ts[1]);
    }

    @Test
    void translateTest4() {
        String[] ts = jp.translate(null, "t");
        assertEquals("t", ts[0]);
        assertEquals("", ts[1]);
    }

    @Test
    void translateTest5() {
        String[] ts = jp.translate(null, "ga");
        assertEquals("が", ts[0]);
        assertEquals("", ts[1]);
    }

    @Test
    void translateTest6() {
        String[] ts = jp.translate(null, "xa");
        assertEquals("ぁ", ts[0]);
        assertEquals("", ts[1]);
    }

    @Test
    void translateTest7() {
        String[] ts = jp.translate(null, "nn");
        assertEquals("ん", ts[0]);
        assertEquals("", ts[1]);
    }

    @Test
    void translateTest8() {
        String[] ts = jp.translate(null, "yy");
        assertEquals("っ", ts[0]);
        assertEquals("y", ts[1]);
    }
    @Test
    void translateTest9() {
        String[] ts = jp.translate(null, "rc");
        assertEquals("", ts[0]);
        assertEquals("rc", ts[1]);
    }
    @Test
    void translateTest10() {
        String[] ts = jp.translate(null, "cha");
        assertEquals("ちゃ", ts[0]);
        assertEquals("", ts[1]);
    }
    @Test
    void translateTest11() {
        String[] ts = jp.translate(null, "chh");
        assertEquals("cっ", ts[0]);
        assertEquals("h", ts[1]);
    }
    @Test
    void translateTest12() {
        String[] ts = jp.translate(null, "xya");
        assertEquals("ゃ", ts[0]);
        assertEquals("", ts[1]);
    }
    @Test
    void translateTest13() {
        String[] ts = jp.translate(null, "8ui");//rt8uiの時 8ui,の場合、ui、tru
        //再帰＋２文字の時先頭の文字が1文字で呼ばれるの時
        assertEquals("8うい", ts[0]);
        assertEquals("", ts[1]);
    }
    @Test
    void translateTest14() {
        String[] ts = jp.translate(null, "tru");//再帰もう一回で済む
        assertEquals("tる", ts[0]);
        assertEquals("", ts[1]);
    }
    @Test
    void translateTest15() {
        String[] ts = jp.translate(null, "trc");//再帰もう一回で済む
        assertEquals("t", ts[0]);
        assertEquals("rc", ts[1]);
    }
}