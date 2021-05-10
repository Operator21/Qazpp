package com.standarts.qazpp;

import java.util.ArrayList;

public class DefaultFilesCreator {
    public static void CreateDefaultFiles(){
        FileHelper.ClearQuizFolder();
        //Mass Effect
        Quiz masseffect = new Quiz("Mass Effect", "Stanislav Zdych");
        masseffect.Add(new Question("What is female Shepard's default name?", new String[]{"Jane", "Sarah", "Lucy", "Lara", "Lindsey"}));
        masseffect.Add(new Question("Who created the Genophage?", new String[]{"Salarians", "Turians", "Krogans", "Rachni", "Drell"}));
        masseffect.Add(new Question("Who created the Geth?", new String[]{"Quarians", "Turians", "Asari", "Humans", "Reapers"}));
        masseffect.Add(new Question("What is Samara's daughter Morinth?", new String[]{"Ardat Yakshi", "Spectre", "Justicar"}));
        masseffect.Add(new Question("What was the name of the Prothean V.I on Ilos?", new String[]{"Vigil", "Glyph","EDI"}));
        masseffect.Add(new Question("Male Shepard and Garrus have the same voice actor.", new String[]{"Yes", "No"}));
        FileHelper.WriteToFile(FileHelper.CreateSafeFilename(masseffect.Name()), masseffect.ToJson());

        //Life is strange
        Quiz lis = new Quiz("Life is Strange", "Michaela Meitnerová");
        lis.Add(new Question("Jak se jmenuje nové Life is Strange, které má vyjít v roce 2021", new String[]{"True colors", "Before the Storm", "After the Storm", "New Beginning"}));
        lis.Add(new Question("Jak se jmenuje hlavní postava v Life is strange", new String[]{"Max", "Chloe", "Kate", "Alyssa"}));
        lis.Add(new Question("Life is strange vyšlo v roce: ", new String[]{"2015", "2013", "2011", "2017"}));
        lis.Add(new Question("Life is strange 2 je příběh o dvou: ", new String[]{"bratrech", "sestrách", "dvojčat", "bratrancích"}));
        lis.Add(new Question("Jak se jmenovala kamarádka Chloe, která se ztratila?", new String[]{"Rachel", "Margareth", "Linda", "Amanda"}));
        lis.Add(new Question("Kolik sourozenců má Max?", new String[]{"žádného", "jednoho", "dva", "tři"}));
        lis.Add(new Question("Jak se jmenuje poslední epizoda Life is strange?", new String[]{"Polarized", "Chrysalis", "Chaos Therory", "Out of Time"}));
        lis.Add(new Question("Jak se jmenuje střední škola, na kterou Max chodí?", new String[]{"Blackwell Academy", "Farewell Academy", "Louisianne Academy", "Cambridge Academy"}));
        lis.Add(new Question("Jak se jmenuje bonusová epizoda z Life Is Strange: BTS", new String[]{"Farewell", "Goodbye", "Ahoy", "Treasure map"}));
        lis.Add(new Question("Jakou má Max superschopnost", new String[]{"Vracení času", "Teleportace", "Neviditelnost", "Čtení myšlenek"}));
        lis.Add(new Question("O koho Chloe přišla kvůli dopravní nehodě?", new String[]{"Máma", "Táta", "Sestra", "Bratra"}));
        lis.Add(new Question("Jakou schopnost má Chloe v Life is Strange: BTS?", new String[]{"Odmlouvání", "Čtení myšlenek", "Supersíla", "Lézt lidem na nervy"}));
        lis.Add(new Question("Jak se jmenuje poslední epizoda Life is Strange: BTS", new String[]{"Hell is empty", "Awake", "Brave New World", "Exhausted"}));
        lis.Add(new Question("Celou sérii Life is Strange: BTS tráví čas Chloe s?", new String[]{"Rachel", "Max", "Alyssa", "Victoria"}));
        lis.Add(new Question("Za co sbíráte achievementy v Life is Strange?", new String[]{"Fotky", "Kamínky", "Pohlednice", "Plakáty"}));
        lis.Add(new Question("Za co sbíráte achievementy v Life is Strange: BTS", new String[]{"Graffity", "Zbraně","Náramky", "Víčka od lahví"}));
        lis.Add(new Question("Jak se jmenuje restaurace, ve kterém pracuje Joyce, máma Chloe?", new String[]{"Blue Whales", "Coral Island", "Happy Delphin", "Blue bird"}));
        lis.Add(new Question("Jak se jmenuje kamarád Max?", new String[]{"Warren", "Zachary", "Nathan", "Frank"}));
        lis.Add(new Question("Jak se jmenuje profesor, který vyučuje Fotografování", new String[]{"Jefferson", "Hankson", "Bradley", "Jeffrey"}));
        lis.Add(new Question("Jak se jmenuje hra, ve které hrají Rachel a Chloe?", new String[]{"The Tempest", "The Forest", "The Clouds", "The Nemesis"}));
        FileHelper.WriteToFile(FileHelper.CreateSafeFilename(lis.Name()), lis.ToJson());

        //StarGate
        Quiz sg = new Quiz("StarGate", "Filip Fojtík");
        sg.Add(new Question("Žánr seriálu Hvězdná brána je", new String[]{"Sci-fi", "Fantasy", "Drama", "Akce"}));
        sg.Add(new Question("Kolik má Hvězdná brána chevronů", new String[]{"9", "7", "12", "34"}));
        sg.Add(new Question("SG týmy jsou složeny celkem z kolika lidí?", new String[]{"4", "6", "2", "8"}));
        sg.Add(new Question("První vesmírné plavidlo vytvořené lidmi je", new String[]{"X-302", "X301", "F-302", "X-303 Prometheus"}));
        sg.Add(new Question("Goa'uldi jsou", new String[]{"Falšešní bohové", "Bohové", "Původní stavitelé SG", "V seriálu nejsou"}));
        sg.Add(new Question("Teal'c je původem", new String[]{"Jaffa", "Člověk", "Android", "Bojová helikoptéra"}));
        sg.Add(new Question("Hvězdná brána je", new String[]{"Portál vedoucí na spoustu míst", "Portál vedoucí na Abidos", "Portál vedoucí poze do jiné galaxie"}));
        sg.Add(new Question("Hvězdná brána je vytvořena z", new String[]{"Naquadahu", "Trinia", "Titanu", "Plastu"}));
        sg.Add(new Question("V jedné z epizod se objeví URGO. Urgo je", new String[]{"Sonda mimozemšťanů", "Goa'uld", "Zbraň", "Unas"}));
        sg.Add(new Question("Apophis byl", new String[]{"Goa'uld ", "Přítel Teal'ca", "Člen týmu SG-1", "Azgard"}));
        sg.Add(new Question("Oriové se sjednotili se Zemí", new String[]{"Ne", "Ano"}));
        sg.Add(new Question("Byl Jack O'Neill hostitelem?", new String[]{"Ano, dvakrát", "Ne", "Ano, jednou", "Byl to Goa'uld"}));
        sg.Add(new Question("Hvězdná brána se začala vysílat od roku", new String[]{"1997", "1999", "2000", "1994"}));
        sg.Add(new Question("Hned v pilotním díle zemřel", new String[]{"Major Charles Kawalsky", "Daniel Jackson", "Bra'tac", "Jonas"}));
        sg.Add(new Question("Jak se nazývá -štít- na hvězdné bráně lidí", new String[]{"Iris", "Štít", "Shapa ai", "SG Defend System"}));
        FileHelper.WriteToFile(FileHelper.CreateSafeFilename(sg.Name()), sg.ToJson());
    }


}
