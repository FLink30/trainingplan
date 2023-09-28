package de.hdmstuttgart.trainingsapp.src.model.enums;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isWhitespace;

public enum ProfileAttributes {
    FITNESSLEVEL,
    GOAL,
    SEX;

    /**
     * Konvertiert den Value der Enumkonstante in den eigentlichen Namen
     * der Enumkonstante als String.
     *
     * @param enumValue --> enumValue ist der Value der in der Enumkonstante gespeichert wird
     * @return
     */
    public Enum getConstante(String enumValue) {
        StringBuilder stringbuilder = new StringBuilder();

        for (int i = 0; i < enumValue.length(); i++) {
            char c = enumValue.charAt(i);
            if (isLowerCase(c)) {
                stringbuilder.append(Character.toUpperCase(c));
            }else if(isWhitespace(c)){
                stringbuilder.append("_");
            }else{
                stringbuilder.append(c);
            }
        }

        if (this== ProfileAttributes.FITNESSLEVEL){
            return Fitnesslevel.valueOf(stringbuilder.toString());
        }else if (this== ProfileAttributes.GOAL){
            return Goal.valueOf(stringbuilder.toString());
        }
        return Sex.valueOf(stringbuilder.toString());

    }

}
