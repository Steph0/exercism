class SqueakyClean {
    static String clean(String identifier) {
        StringBuilder result = new StringBuilder("");
        for(int cursor = 0; cursor < identifier.length() ; cursor++){

            char finalLetter = switch(identifier.charAt(cursor)) {
                case '4' -> 'a';
                case '3' -> 'e';
                case '0' -> 'o';
                case '1' -> 'l';
                case '7' -> 't';
                default -> identifier.charAt(cursor);
            };

            if(Character.isSpaceChar(finalLetter)) {
                finalLetter = '_';
            } else if(cursor < identifier.length()-1 && finalLetter == '-'){
                finalLetter = Character.toUpperCase(identifier.charAt(++cursor));
            }

            if(finalLetter != '_' && !Character.isAlphabetic(finalLetter)){
                continue;
            }

            result.append(finalLetter);
        }

        return result.toString();
    }
}
