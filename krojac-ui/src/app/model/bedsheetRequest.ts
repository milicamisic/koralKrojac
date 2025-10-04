export class BedsheetRequest {
  type!: string;     // FITTED or FLAT
  length!: number;
  width!: number;
  height!: number;   // mattress height
  overhang!: number; // for flat sheet only

  constructor(init?: Partial<BedsheetRequest>) {
    Object.assign(this, init);
  }
}
