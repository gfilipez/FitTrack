package com.gfilipe.fittrack;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

import com.gfilipe.fittrack.Models.Exercise;
import com.gfilipe.fittrack.Models.InfoItem;
import com.gfilipe.fittrack.Models.MealOption;
import com.gfilipe.fittrack.Models.MealSlot;
import com.gfilipe.fittrack.Models.Recipe;
import com.gfilipe.fittrack.Models.WorkoutDay;

public class MainActivity extends Activity {

    private static final int BG = Color.parseColor("#121212");
    private static final int CARD_BG = Color.parseColor("#1E1E1E");
    private static final int ACCENT = Color.parseColor("#E53E3E");
    private static final int TEXT_PRIMARY = Color.parseColor("#F5F5F5");
    private static final int TEXT_SECONDARY = Color.parseColor("#AAAAAA");

    private final Deque<Screen> stack = new ArrayDeque<>();
    private SharedPreferences prefs;

    private static class Screen {
        final String type;
        final String p1;
        final String p2;

        Screen(String type) {
            this(type, null, null);
        }

        Screen(String type, String p1) {
            this(type, p1, null);
        }

        Screen(String type, String p1, String p2) {
            this.type = type;
            this.p1 = p1;
            this.p2 = p2;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = getSharedPreferences("fittrack_prefs", MODE_PRIVATE);
        stack.push(new Screen("home"));
        render();
    }

    @Override
    public void onBackPressed() {
        if (stack.size() > 1) {
            stack.pop();
            render();
        } else {
            super.onBackPressed();
        }
    }

    private void goBack() {
        onBackPressed();
    }

    private void navigate(Screen s) {
        stack.push(s);
        render();
    }

    private int dp(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
    }

    private int sp(int value) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, getResources().getDisplayMetrics());
    }

    // ---------------- RENDER ----------------

    private void render() {
        Screen s = stack.peek();

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(dp(16), dp(28), dp(16), dp(40));
        root.setLayoutParams(new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        if (stack.size() > 1) {
            TextView back = textView("← Voltar", 16, ACCENT, true);
            back.setPadding(0, 0, 0, dp(12));
            back.setOnClickListener(v -> goBack());
            root.addView(back);
        }

        TextView title = textView(titleFor(s), 22, TEXT_PRIMARY, true);
        title.setPadding(0, 0, 0, dp(16));
        root.addView(title);

        switch (s.type) {
            case "home":
                buildHome(root);
                break;
            case "workoutList":
                buildWorkoutList(root);
                break;
            case "workoutDetail":
                buildWorkoutDetail(root, s.p1);
                break;
            case "mealSlotList":
                buildMealSlotList(root);
                break;
            case "mealOptionList":
                buildMealOptionList(root, s.p1);
                break;
            case "mealOptionDetail":
                buildMealOptionDetail(root, s.p1, s.p2);
                break;
            case "recipeList":
                buildRecipeList(root);
                break;
            case "recipeDetail":
                buildRecipeDetail(root, s.p1);
                break;
            case "infoList":
                buildInfoList(root, s.p1);
                break;
            case "infoDetail":
                buildInfoDetail(root, s.p1, s.p2);
                break;
            default:
                break;
        }

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(BG);
        scroll.addView(root);
        setContentView(scroll);
    }

    private String titleFor(Screen s) {
        switch (s.type) {
            case "home":
                return "FitTrack — O meu plano";
            case "workoutList":
                return "Treinos";
            case "workoutDetail":
                return findWorkout(s.p1).title;
            case "mealSlotList":
                return "Refeições";
            case "mealOptionList":
                return findSlot(s.p1).title;
            case "mealOptionDetail":
                return findOption(s.p1, s.p2).name;
            case "recipeList":
                return "Receitas";
            case "recipeDetail":
                return findRecipe(s.p1).title;
            case "infoList":
                return "supplements".equals(s.p1) ? "Suplementos" : "Notas gerais";
            case "infoDetail":
                return findInfo(s.p1, s.p2).title;
            default:
                return "FitTrack";
        }
    }

    // ---------------- LOOKUPS ----------------

    private WorkoutDay findWorkout(String id) {
        for (WorkoutDay w : PlanData.WORKOUTS) if (w.id.equals(id)) return w;
        return null;
    }

    private MealSlot findSlot(String id) {
        for (MealSlot slot : PlanData.MEAL_SLOTS) if (slot.id.equals(id)) return slot;
        return null;
    }

    private MealOption findOption(String slotId, String optionId) {
        MealSlot slot = findSlot(slotId);
        if (slot == null) return null;
        for (MealOption o : slot.options) if (o.id.equals(optionId)) return o;
        return null;
    }

    private Recipe findRecipe(String id) {
        for (Recipe r : PlanData.RECIPES) if (r.id.equals(id)) return r;
        return null;
    }

    private List<InfoItem> infoListFor(String key) {
        return "supplements".equals(key) ? PlanData.SUPPLEMENTS : PlanData.GENERAL_NOTES;
    }

    private InfoItem findInfo(String key, String id) {
        for (InfoItem i : infoListFor(key)) if (i.id.equals(id)) return i;
        return null;
    }

    // ---------------- SCREENS ----------------

    private void buildHome(LinearLayout root) {
        root.addView(textView("Plano pessoal de treino e alimentação", 14, TEXT_SECONDARY, false));
        spacer(root, 12);
        addMenuItem(root, "Treinos", "Dias de treino e exercícios", () -> navigate(new Screen("workoutList")));
        addMenuItem(root, "Refeições", "Pequeno-almoço, almoço, lanche, jantar...", () -> navigate(new Screen("mealSlotList")));
        addMenuItem(root, "Receitas", "Receitas detalhadas com preparação", () -> navigate(new Screen("recipeList")));
        addMenuItem(root, "Suplementos", "Informação sobre suplementação", () -> navigate(new Screen("infoList", "supplements")));
        addMenuItem(root, "Notas gerais", "Água, refeições e regras do plano", () -> navigate(new Screen("infoList", "notes")));
    }

    private void buildWorkoutList(LinearLayout root) {
        for (WorkoutDay w : PlanData.WORKOUTS) {
            addListCard(root, w.title, w.subtitle, () -> navigate(new Screen("workoutDetail", w.id)));
        }
    }

    private void buildWorkoutDetail(LinearLayout root, String id) {
        WorkoutDay w = findWorkout(id);
        if (w == null) return;
        root.addView(textView(w.subtitle, 14, TEXT_SECONDARY, false));
        spacer(root, 12);
        for (Exercise e : w.exercises) {
            LinearLayout card = card();
            card.addView(textView(e.name, 16, TEXT_PRIMARY, true));
            TextView detail = textView(e.detail, 14, TEXT_SECONDARY, false);
            detail.setPadding(0, dp(4), 0, 0);
            card.addView(detail);
            root.addView(card);
        }
        spacer(root, 8);
        boolean done = prefs.getBoolean("workout_done_" + w.id, false);
        TextView button = textView(done ? "✓  Concluído" : "Concluir", 16, Color.WHITE, true);
        button.setGravity(Gravity.CENTER);
        button.setBackgroundColor(ACCENT);
        button.setPadding(dp(16), dp(14), dp(16), dp(14));
        button.setOnClickListener(v -> {
            boolean newDone = !prefs.getBoolean("workout_done_" + w.id, false);
            prefs.edit().putBoolean("workout_done_" + w.id, newDone).apply();
            render();
        });
        root.addView(button);
    }

    private void buildMealSlotList(LinearLayout root) {
        for (MealSlot slot : PlanData.MEAL_SLOTS) {
            addListCard(root, slot.title, slot.options.size() + " opções", () -> navigate(new Screen("mealOptionList", slot.id)));
        }
    }

    private void buildMealOptionList(LinearLayout root, String slotId) {
        MealSlot slot = findSlot(slotId);
        if (slot == null) return;
        if (slot.note != null) {
            root.addView(noteBox(slot.note));
            spacer(root, 8);
        }
        for (MealOption o : slot.options) {
            addListCard(root, o.name, null, () -> navigate(new Screen("mealOptionDetail", slot.id, o.id)));
        }
    }

    private void buildMealOptionDetail(LinearLayout root, String slotId, String optionId) {
        MealOption o = findOption(slotId, optionId);
        if (o == null) return;
        if ((o.ingredients == null || o.ingredients.isEmpty()) && o.prep == null) {
            root.addView(noteBox("Ainda sem detalhe guardado para esta opção. Podes adicionar os ingredientes mais tarde em PlanData.java."));
        }
        if (o.ingredients != null) {
            for (String ing : o.ingredients) {
                LinearLayout card = card();
                card.addView(textView(ing, 14, TEXT_PRIMARY, false));
                root.addView(card);
            }
        }
        if (o.prep != null) {
            spacer(root, 8);
            root.addView(textView("Preparação", 18, TEXT_PRIMARY, true));
            spacer(root, 4);
            root.addView(textView(o.prep, 14, TEXT_PRIMARY, false));
        }
        if (o.note != null) {
            spacer(root, 8);
            root.addView(noteBox(o.note));
        }
    }

    private void buildRecipeList(LinearLayout root) {
        for (Recipe r : PlanData.RECIPES) {
            addListCard(root, r.title, r.source, () -> navigate(new Screen("recipeDetail", r.id)));
        }
        if (!PlanData.RECIPE_TITLES_WITHOUT_DETAIL.isEmpty()) {
            spacer(root, 8);
            root.addView(textView("Sem detalhe guardado ainda", 14, TEXT_SECONDARY, true));
            spacer(root, 4);
            for (String title : PlanData.RECIPE_TITLES_WITHOUT_DETAIL) {
                LinearLayout card = card();
                card.addView(textView(title, 14, TEXT_PRIMARY, false));
                root.addView(card);
            }
        }
    }

    private void buildRecipeDetail(LinearLayout root, String id) {
        Recipe r = findRecipe(id);
        if (r == null) return;
        if (r.source != null) {
            root.addView(textView(r.source, 13, TEXT_SECONDARY, false));
            spacer(root, 8);
        }
        root.addView(textView("Ingredientes", 18, TEXT_PRIMARY, true));
        spacer(root, 4);
        for (String ing : r.ingredients) {
            root.addView(textView("•  " + ing, 14, TEXT_PRIMARY, false));
        }
        spacer(root, 12);
        root.addView(textView("Preparação", 18, TEXT_PRIMARY, true));
        spacer(root, 4);
        root.addView(textView(r.prep, 14, TEXT_PRIMARY, false));
    }

    private void buildInfoList(LinearLayout root, String key) {
        for (InfoItem item : infoListFor(key)) {
            addListCard(root, item.title, null, () -> navigate(new Screen("infoDetail", key, item.id)));
        }
    }

    private void buildInfoDetail(LinearLayout root, String key, String id) {
        InfoItem item = findInfo(key, id);
        if (item == null) return;
        root.addView(textView(item.text, 15, TEXT_PRIMARY, false));
    }

    // ---------------- WIDGET HELPERS ----------------

    private interface Action {
        void run();
    }

    private TextView textView(String text, int spSize, int color, boolean bold) {
        TextView tv = new TextView(this);
        tv.setText(text);
        tv.setTextSize(spSize);
        tv.setTextColor(color);
        if (bold) tv.setTypeface(tv.getTypeface(), android.graphics.Typeface.BOLD);
        return tv;
    }

    private void spacer(LinearLayout root, int heightDp) {
        View v = new View(this);
        v.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp(heightDp)));
        root.addView(v);
    }

    private LinearLayout card() {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setBackgroundColor(CARD_BG);
        card.setPadding(dp(14), dp(12), dp(14), dp(12));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, dp(8));
        card.setLayoutParams(lp);
        return card;
    }

    private void addListCard(LinearLayout root, String title, String subtitle, Action onClick) {
        LinearLayout card = card();
        card.setClickable(true);
        card.setFocusable(true);
        card.addView(textView(title, 16, TEXT_PRIMARY, true));
        if (subtitle != null) {
            TextView sub = textView(subtitle, 13, TEXT_SECONDARY, false);
            sub.setPadding(0, dp(4), 0, 0);
            card.addView(sub);
        }
        card.setOnClickListener(v -> onClick.run());
        root.addView(card);
    }

    private void addMenuItem(LinearLayout root, String title, String subtitle, Action onClick) {
        addListCard(root, title, subtitle, onClick);
    }

    private LinearLayout noteBox(String text) {
        LinearLayout box = new LinearLayout(this);
        box.setOrientation(LinearLayout.VERTICAL);
        box.setBackgroundColor(Color.parseColor("#332222"));
        box.setPadding(dp(14), dp(12), dp(14), dp(12));
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lp.setMargins(0, 0, 0, dp(8));
        box.setLayoutParams(lp);
        box.addView(textView(text, 14, TEXT_PRIMARY, false));
        return box;
    }
}
