import { SubjectIcons, SubjectColors } from "./Icons";

export const MAIN_SUBJECTS = [
  "Sistemas Informaticos",
  "Entornos de Desarrollo",
  "Desarrollo Web en Entorno Cliente",
  "Programacion",
];

export const EXAM_SUBJECTS = [
  "Sistemas Informaticos",
  "Sistemes Informàtics",
  "Entornos de Desarrollo",
  "Preguntas Directas",
];

export const isExamSubject = (subject) => EXAM_SUBJECTS.includes(subject);

export const isExamDeck = (deck) => {
  if (!deck) return false;
  const id = deck.id || "";
  const subj = deck.subject || "";
  if (isExamSubject(subj)) return true;
  return (
    /-(?:ed|si)-/.test(id) ||
    /^(?:entornos-desarrollo|sistemas-informaticos|interconexion-redes)/.test(
      id,
    ) ||
    /^unidad\d/.test(id) ||
    id === "pd-all" ||
    /^practicas-(?:ed|si)/.test(id)
  );
};

export const getSubjectIcon = (subject) => {
  return SubjectIcons[subject] || SubjectIcons.default;
};

export const getSubjectColor = (subject) => {
  return SubjectColors[subject] || SubjectColors.default;
};
