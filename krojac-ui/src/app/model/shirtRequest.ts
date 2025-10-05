export class ShirtRequest {
  bust!: number;  // chest circumference in cm
  waist!: number; // waist circumference in cm
  torsoLength!: number;         // torso length in cm
  hasSleeves!: boolean;         // whether it has sleeves
  shoulder!: number;       // shoulder width in cm
  sleeveLength!: number;        // sleeve length in cm
  fit!: string;                 // STANDARD, SLIM, OVERSIZED

  constructor(init?: Partial<ShirtRequest>) {
    Object.assign(this, init);
  }
}
