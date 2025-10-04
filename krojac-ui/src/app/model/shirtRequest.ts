export class ShirtRequest {
  bust!: number;  // chest circumference in cm
  torsoLength!: number;         // torso length in cm
  hasSleeves!: boolean;         // whether it has sleeves
  sleeveLength!: number;        // sleeve length in cm
  shoulderWidth!: number;       // shoulder width in cm
  fit!: string;                 // STANDARD, SLIM, OVERSIZED

  constructor(init?: Partial<ShirtRequest>) {
    Object.assign(this, init);
  }
}
