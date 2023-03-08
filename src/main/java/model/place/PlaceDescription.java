package model.place;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor

public class PlaceDescription {

    private String name;
    private String kinds;
    private String rate;
    private String wikipedia;
    private String image;

    @Override
    public String toString() {
        return "PlaceDescription{\n" +
                "\nname='" + name + '\'' +
                "\nkinds='" + kinds + '\'' +
                "\nrate='" + rate + '\'' +
                "\nwikipedia='" + wikipedia + '\'' +
                "\nimage='" + image + '\'' +
                '}' + '\n';
    }
}
