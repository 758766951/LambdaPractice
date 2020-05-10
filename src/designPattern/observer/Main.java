package designPattern.observer;


/*有一个外部接口Weatherdata类提供三个测量值：温度，湿度，气压。我们需要实现三个使用天气数据的布告板：目前状况（温度，湿度，气压），天气统计（平均温度，最低温度，最高温度），天气预报。一旦Weatherdata提供了新的测量时，这些布告板必须马上更换内容。
此系统必须可扩展，可以让其他开发人员建立新的布告板，用户可以随心所欲的添加或者删除自己想要看到的布告板。*/
public class Main {
    public static void main(String[] args){
        /**
         * 测试1：自定义观察者模式
         * 测试目前状况布告板
         * Current conditions: 80.0F degrees and 65.0%humidity
         * Current conditions: 75.0F degrees and 68.0%humidity
         * Current conditions: 70.0F degrees and 69.0%humidity
         */
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(80,65,30.4f);
        weatherData.setMeasurements(75,68,32.4f);
        weatherData.setMeasurements(70,69,30.5f);



    }
}
