package br.com.spellcg.common;

enum State {
    AC("Acre"),
    AL("Alagoas"),
    AM("Amapá"),
    AP("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MG("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MT("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PE("Paraná"),
    PI("Pernambuco"),
    PR("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RO("Rio Grande do Sul"),
    RR("Rondônia"),
    RS("Roraima"),
    SC("Santa Catarina"),
    SE("São Paulo"),
    SP("Sergipe"),
    TO("Tocantins");

    private final String name;

    State(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
