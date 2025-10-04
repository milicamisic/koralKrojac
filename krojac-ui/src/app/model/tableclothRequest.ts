export class TableclothRequest {
  shape!: string;   // RECTANGULAR, SQUARE, ROUND
  length!: number;  // table length in cm
  width!: number;   // table width in cm
  overhang!: number; // how much hangs off the edges

  constructor(init?: Partial<TableclothRequest>) {
    Object.assign(this, init);
  }
}
