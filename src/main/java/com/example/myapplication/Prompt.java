package com.example.myapplication;
import java.util.HashMap;
import java.util.Map;


public class Prompt
{
    public static Map createPrompt(String input)
    {
        int steps = 28;
        String PositivePrompt = "perfect, composition, intricate details, " +
                "detailed, trending on artstation, High quality";

        String NegativePrompt = "Extra Legs, Extra Hands, poorly Rendered face, poorly drawn face, " +
                "watermark, poorly drawn hands, poorly rendered hands, low resolution, images cut out at the, " +
                "top left right bottom, bad composition, mutated body parts, blurry image, " +
                "disfigured, oversaturated, bad anatomy, deformed body features, cloned, face mutated " +
                "hands, ((((mutated hands and fingers))))";

        String Styles = "anime, steam punk, cyber punk, pixar style, " +
                "disney style, 3D character, building, comic art, cute creature, " +
                "comic art, artstation, photorealistick , " +
                "digitalart, fantasy, movies, pixel art, comics";

        String regex = "^(?:(?:A|a)nime|(?:S|s)team(?: |)(?:P|p)unk|(?:C|c)yber(?: |)" +
                "(?:P|p)unk|(?:P|p)ixar(?: |)(?:S|s)tyle|(?:D|d)isney(?: |)" +
                "(?:S|s)tyle|3(?:D|d)(?: |)character|building|comic(?: |)art|cute(?: |)" +
                "creature|art(?: |)station|photorealistick|digital(?: |)" +
                "art|fantasy|movies|pixel(?: |)art|comics)";

        String result = PositivePrompt + input;
        String negative_prompt = Duplicates.removeCommon(result, NegativePrompt);

        Map<String, Object> payload = new HashMap<>();
        payload.put("prompt", result);
        payload.put("steps", steps);
        payload.put("negative_prompt", negative_prompt);
        return payload;
    }
}
