export interface ShirtRequest {
  chestCircumference: number;
  torsoLength: number;
  hasSleeves: boolean;
  sleeveLength: number;
  shoulderWidth: number;
  fit: string; // "Loose", "Slim", "Standard"
}