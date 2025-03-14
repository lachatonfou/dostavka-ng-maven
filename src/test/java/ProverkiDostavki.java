import org.example.RaschetDostavki;
import org.testng.annotations.Test;
import org.testng.Assert;

public class ProverkiDostavki {
    @Test(groups = {"positive"})
    void positiveTest() {
        RaschetDostavki raschet = new RaschetDostavki();
        Assert.assertEquals((raschet.StoimostDostavki(8, true, true, "Visokaya")), 840);
    }

    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Расстояние не может быть меньше 0")
    void exeption_test1(){
        RaschetDostavki raschet = new RaschetDostavki();
        raschet.StoimostDostavki(-10, true, true, "Obichnaya");
    }

    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Нельзя возить хрупкий товар на расстояние свыше 30 км. Расчет доставки невозможен")
    void exeption_test2(){
        RaschetDostavki raschet = new RaschetDostavki();
        raschet.StoimostDostavki(35, true, true, "Obichnaya");
    }


}
