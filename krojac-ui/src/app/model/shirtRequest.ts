export class ShirtRequest {
  bust!: number;  // chest circumference in cm
  torsoLength!: number;         // torso length in cm
  shoulderWidth!: number;       // shoulder width in cm
  fit!: string;                 // STANDARD, SLIM, OVERSIZED
  sleeveType!: string;    // NONE, SHORT, LONG

  constructor(init?: Partial<ShirtRequest>) {
    Object.assign(this, init);
  }
}
